/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.caches.resolve;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/multiplatform")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class MultiplatformAnalysisTestGenerated extends AbstractMultiplatformAnalysisTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("aliasesTypeMismatch")
    public void testAliasesTypeMismatch() throws Exception {
        runTest("idea/testData/multiplatform/aliasesTypeMismatch/");
    }

    public void testAllFilesPresentInMultiplatform() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/testData/multiplatform"), Pattern.compile("^([^\\.]+)$"), null, false);
    }

    @TestMetadata("callableReferences")
    public void testCallableReferences() throws Exception {
        runTest("idea/testData/multiplatform/callableReferences/");
    }

    @TestMetadata("constructorsOfExpect")
    public void testConstructorsOfExpect() throws Exception {
        runTest("idea/testData/multiplatform/constructorsOfExpect/");
    }

    @TestMetadata("correctOverloadResolutionAmbiguity")
    public void testCorrectOverloadResolutionAmbiguity() throws Exception {
        runTest("idea/testData/multiplatform/correctOverloadResolutionAmbiguity/");
    }

    @TestMetadata("diamondActualInBottom")
    public void testDiamondActualInBottom() throws Exception {
        runTest("idea/testData/multiplatform/diamondActualInBottom/");
    }

    @TestMetadata("diamondActualOnOnePath")
    public void testDiamondActualOnOnePath() throws Exception {
        runTest("idea/testData/multiplatform/diamondActualOnOnePath/");
    }

    @TestMetadata("diamondDuplicateActuals")
    public void testDiamondDuplicateActuals() throws Exception {
        runTest("idea/testData/multiplatform/diamondDuplicateActuals/");
    }

    @TestMetadata("diamondModuleDependency1")
    public void testDiamondModuleDependency1() throws Exception {
        runTest("idea/testData/multiplatform/diamondModuleDependency1/");
    }

    @TestMetadata("diamondModuleDependency2")
    public void testDiamondModuleDependency2() throws Exception {
        runTest("idea/testData/multiplatform/diamondModuleDependency2/");
    }

    @TestMetadata("diamondSeesTwoActuals")
    public void testDiamondSeesTwoActuals() throws Exception {
        runTest("idea/testData/multiplatform/diamondSeesTwoActuals/");
    }

    @TestMetadata("differentKindsOfDependencies")
    public void testDifferentKindsOfDependencies() throws Exception {
        runTest("idea/testData/multiplatform/differentKindsOfDependencies/");
    }

    @TestMetadata("duplicateActualsExplicit")
    public void testDuplicateActualsExplicit() throws Exception {
        runTest("idea/testData/multiplatform/duplicateActualsExplicit/");
    }

    @TestMetadata("duplicateActualsImplicit")
    public void testDuplicateActualsImplicit() throws Exception {
        runTest("idea/testData/multiplatform/duplicateActualsImplicit/");
    }

    @TestMetadata("duplicateActualsOneWeaklyIncompatible")
    public void testDuplicateActualsOneWeaklyIncompatible() throws Exception {
        runTest("idea/testData/multiplatform/duplicateActualsOneWeaklyIncompatible/");
    }

    @TestMetadata("duplicateActualsOneWithStrongIncompatibility")
    public void testDuplicateActualsOneWithStrongIncompatibility() throws Exception {
        runTest("idea/testData/multiplatform/duplicateActualsOneWithStrongIncompatibility/");
    }

    @TestMetadata("duplicateExpectsExplicit")
    public void testDuplicateExpectsExplicit() throws Exception {
        runTest("idea/testData/multiplatform/duplicateExpectsExplicit/");
    }

    @TestMetadata("duplicateExpectsImplicit")
    public void testDuplicateExpectsImplicit() throws Exception {
        runTest("idea/testData/multiplatform/duplicateExpectsImplicit/");
    }

    @TestMetadata("duplicateExpectsWithStrongIncompatibility")
    public void testDuplicateExpectsWithStrongIncompatibility() throws Exception {
        runTest("idea/testData/multiplatform/duplicateExpectsWithStrongIncompatibility/");
    }

    @TestMetadata("extensionOnExpect")
    public void testExtensionOnExpect() throws Exception {
        runTest("idea/testData/multiplatform/extensionOnExpect/");
    }

    @TestMetadata("hierarcicalActualization")
    public void testHierarcicalActualization() throws Exception {
        runTest("idea/testData/multiplatform/hierarcicalActualization/");
    }

    @TestMetadata("incompleteActualization")
    public void testIncompleteActualization() throws Exception {
        runTest("idea/testData/multiplatform/incompleteActualization/");
    }

    @TestMetadata("internalFromDependsOn")
    public void testInternalFromDependsOn() throws Exception {
        runTest("idea/testData/multiplatform/internalFromDependsOn/");
    }

    @TestMetadata("internalFromDependsOnOfProduction")
    public void testInternalFromDependsOnOfProduction() throws Exception {
        runTest("idea/testData/multiplatform/internalFromDependsOnOfProduction/");
    }

    @TestMetadata("internalFromProduction")
    public void testInternalFromProduction() throws Exception {
        runTest("idea/testData/multiplatform/internalFromProduction/");
    }

    @TestMetadata("jsNameClash")
    public void testJsNameClash() throws Exception {
        runTest("idea/testData/multiplatform/jsNameClash/");
    }

    @TestMetadata("jvmDefaultNonMpp")
    public void testJvmDefaultNonMpp() throws Exception {
        runTest("idea/testData/multiplatform/jvmDefaultNonMpp/");
    }

    @TestMetadata("kt41218")
    public void testKt41218() throws Exception {
        runTest("idea/testData/multiplatform/kt41218/");
    }

    @TestMetadata("lambdas")
    public void testLambdas() throws Exception {
        runTest("idea/testData/multiplatform/lambdas/");
    }

    @TestMetadata("languageConstructions")
    public void testLanguageConstructions() throws Exception {
        runTest("idea/testData/multiplatform/languageConstructions/");
    }

    @TestMetadata("multilevelParents")
    public void testMultilevelParents() throws Exception {
        runTest("idea/testData/multiplatform/multilevelParents/");
    }

    @TestMetadata("platformSpecificChecksInCommon")
    public void testPlatformSpecificChecksInCommon() throws Exception {
        runTest("idea/testData/multiplatform/platformSpecificChecksInCommon/");
    }

    @TestMetadata("qualifiedReceiver")
    public void testQualifiedReceiver() throws Exception {
        runTest("idea/testData/multiplatform/qualifiedReceiver/");
    }

    @TestMetadata("recursiveTypes")
    public void testRecursiveTypes() throws Exception {
        runTest("idea/testData/multiplatform/recursiveTypes/");
    }

    @TestMetadata("simple")
    public void testSimple() throws Exception {
        runTest("idea/testData/multiplatform/simple/");
    }

    @TestMetadata("supertypes")
    public void testSupertypes() throws Exception {
        runTest("idea/testData/multiplatform/supertypes/");
    }

    @TestMetadata("transitiveDependencyOnCommonSourceSets")
    public void testTransitiveDependencyOnCommonSourceSets() throws Exception {
        runTest("idea/testData/multiplatform/transitiveDependencyOnCommonSourceSets/");
    }

    @TestMetadata("typeAliasToExpectClassExplicitReference")
    public void testTypeAliasToExpectClassExplicitReference() throws Exception {
        runTest("idea/testData/multiplatform/typeAliasToExpectClassExplicitReference/");
    }

    @TestMetadata("typeAliases")
    public void testTypeAliases() throws Exception {
        runTest("idea/testData/multiplatform/typeAliases/");
    }

    @TestMetadata("typeParameters")
    public void testTypeParameters() throws Exception {
        runTest("idea/testData/multiplatform/typeParameters/");
    }

    @TestMetadata("useCorrectBuiltIns")
    public void testUseCorrectBuiltIns() throws Exception {
        runTest("idea/testData/multiplatform/useCorrectBuiltIns/");
    }

    @TestMetadata("weaklyIncompatibleActualInIntermediateModule")
    public void testWeaklyIncompatibleActualInIntermediateModule() throws Exception {
        runTest("idea/testData/multiplatform/weaklyIncompatibleActualInIntermediateModule/");
    }
}
