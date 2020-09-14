// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
// KT-34166: Translation of loop over literal completely removes the validation of step
// DONT_TARGET_EXACT_BACKEND: JS
import kotlin.test.*

fun zero() = 0

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        for (i in 1u..7u step zero()) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        for (i in 1uL..7uL step zero().toLong()) {
        }
    }

    return "OK"
}