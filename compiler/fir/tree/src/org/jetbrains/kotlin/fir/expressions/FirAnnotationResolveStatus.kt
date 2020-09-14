/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.expressions

enum class FirAnnotationResolveStatus {
    Unresolved,
    PartiallyResolved, // only literals, annotations, class literals and enums
    Resolved
}