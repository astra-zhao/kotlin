/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.resolve.transformers.body.resolve

import org.jetbrains.kotlin.fir.FirCallResolver
import org.jetbrains.kotlin.fir.FirQualifiedNameResolver
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.PrivateForInline
import org.jetbrains.kotlin.fir.declarations.FirDeclaration
import org.jetbrains.kotlin.fir.declarations.FirFile
import org.jetbrains.kotlin.fir.declarations.FirResolvePhase
import org.jetbrains.kotlin.fir.resolve.*
import org.jetbrains.kotlin.fir.resolve.calls.ResolutionContext
import org.jetbrains.kotlin.fir.resolve.calls.ResolutionStageRunner
import org.jetbrains.kotlin.fir.resolve.dfa.FirDataFlowAnalyzer
import org.jetbrains.kotlin.fir.resolve.inference.FirCallCompleter
import org.jetbrains.kotlin.fir.resolve.inference.InferenceComponents
import org.jetbrains.kotlin.fir.resolve.inference.inferenceComponents
import org.jetbrains.kotlin.fir.resolve.providers.FirSymbolProvider
import org.jetbrains.kotlin.fir.resolve.transformers.*
import org.jetbrains.kotlin.fir.scopes.FirScope
import org.jetbrains.kotlin.fir.scopes.impl.FirLocalScope
import org.jetbrains.kotlin.fir.types.FirTypeRef
import org.jetbrains.kotlin.fir.types.builder.buildImplicitTypeRef

abstract class FirAbstractBodyResolveTransformer(phase: FirResolvePhase) : FirAbstractPhaseTransformer<ResolutionMode>(phase) {
    abstract val context: BodyResolveContext
    abstract val components: BodyResolveTransformerComponents
    abstract val resolutionContext: ResolutionContext

    @set:PrivateForInline
    abstract var implicitTypeOnly: Boolean
        internal set

    final override val session: FirSession get() = components.session

    protected inline fun <T> withLocalScopeCleanup(crossinline l: () -> T): T {
        return context.withTowerDataCleanup(l)
    }

    protected inline fun <T> withNewLocalScope(crossinline l: () -> T): T {
        return context.withTowerDataCleanup {
            addNewLocalScope()
            l()
        }
    }

    protected fun addNewLocalScope() {
        context.addLocalScope(FirLocalScope())
    }

    protected fun addLocalScope(localScope: FirLocalScope?) {
        if (localScope == null) return
        context.addLocalScope(localScope)
    }

    @OptIn(PrivateForInline::class)
    internal inline fun <T> withFullBodyResolve(crossinline l: () -> T): T {
        if (!implicitTypeOnly) return l()
        implicitTypeOnly = false
        return try {
            l()
        } finally {
            implicitTypeOnly = true
        }
    }

    protected inline val localScopes: List<FirLocalScope> get() = components.localScopes

    protected inline val noExpectedType: FirTypeRef get() = components.noExpectedType

    protected inline val symbolProvider: FirSymbolProvider get() = components.symbolProvider

    protected inline val implicitReceiverStack: ImplicitReceiverStack get() = components.implicitReceiverStack
    protected inline val inferenceComponents: InferenceComponents get() = session.inferenceComponents
    protected inline val resolutionStageRunner: ResolutionStageRunner get() = components.resolutionStageRunner
    protected inline val samResolver: FirSamResolver get() = components.samResolver
    protected inline val typeResolverTransformer: FirSpecificTypeResolverTransformer get() = components.typeResolverTransformer
    protected inline val callResolver: FirCallResolver get() = components.callResolver
    protected inline val callCompleter: FirCallCompleter get() = components.callCompleter
    protected inline val dataFlowAnalyzer: FirDataFlowAnalyzer<*> get() = components.dataFlowAnalyzer
    protected inline val scopeSession: ScopeSession get() = components.scopeSession
    protected inline val file: FirFile get() = components.file
    protected inline val integerLiteralTypeApproximator: IntegerLiteralTypeApproximationTransformer get() = components.integerLiteralTypeApproximator
    protected inline val integerOperatorsTypeUpdater: IntegerOperatorsTypeUpdater get() = components.integerOperatorsTypeUpdater

    val ResolutionMode.expectedType: FirTypeRef?
        get() = when (this) {
            is ResolutionMode.WithExpectedType -> expectedTypeRef
            is ResolutionMode.ContextIndependent -> noExpectedType
            else -> null
        }

    class BodyResolveTransformerComponents(
        override val session: FirSession,
        override val scopeSession: ScopeSession,
        val transformer: FirBodyResolveTransformer,
        val context: BodyResolveContext
    ) : BodyResolveComponents {
        override val fileImportsScope: List<FirScope> get() = context.fileImportsScope
        override val towerDataElements: List<FirTowerDataElement> get() = context.towerDataContext.towerDataElements
        override val localScopes: FirLocalScopes get() = context.towerDataContext.localScopes

        override val towerDataContext: FirTowerDataContext get() = context.towerDataContext

        override val file: FirFile get() = context.file
        override val implicitReceiverStack: ImplicitReceiverStack get() = context.implicitReceiverStack
        override val containingDeclarations: List<FirDeclaration> get() = context.containers
        override val towerDataContextForAnonymousFunctions: TowerDataContextForAnonymousFunctions get() = context.towerDataContextForAnonymousFunctions
        override val returnTypeCalculator: ReturnTypeCalculator get() = context.returnTypeCalculator
        override val container: FirDeclaration get() = context.containerIfAny!!

        override val noExpectedType: FirTypeRef = buildImplicitTypeRef()
        override val symbolProvider: FirSymbolProvider = session.firSymbolProvider

        override val resolutionStageRunner: ResolutionStageRunner = ResolutionStageRunner()
        override val samResolver: FirSamResolver = FirSamResolverImpl(session, scopeSession)
        private val qualifiedResolver: FirQualifiedNameResolver = FirQualifiedNameResolver(this)
        override val callResolver: FirCallResolver = FirCallResolver(
            this,
            qualifiedResolver
        )
        val typeResolverTransformer = FirSpecificTypeResolverTransformer(
            session
        )
        override val callCompleter: FirCallCompleter = FirCallCompleter(transformer, this)
        override val dataFlowAnalyzer: FirDataFlowAnalyzer<*> =
            FirDataFlowAnalyzer.createFirDataFlowAnalyzer(this, context.dataFlowAnalyzerContext)
        override val syntheticCallGenerator: FirSyntheticCallGenerator = FirSyntheticCallGenerator(this)
        override val integerLiteralTypeApproximator: IntegerLiteralTypeApproximationTransformer =
            IntegerLiteralTypeApproximationTransformer(symbolProvider, session.inferenceComponents.ctx, session)
        override val doubleColonExpressionResolver: FirDoubleColonExpressionResolver =
            FirDoubleColonExpressionResolver(session, integerLiteralTypeApproximator)
        override val integerOperatorsTypeUpdater: IntegerOperatorsTypeUpdater = IntegerOperatorsTypeUpdater(integerLiteralTypeApproximator)
        override val outerClassManager: FirOuterClassManager = FirOuterClassManager(session, context.outerLocalClassForNested)
    }
}
