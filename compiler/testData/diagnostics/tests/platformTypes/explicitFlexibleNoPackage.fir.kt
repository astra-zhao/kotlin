// !DIAGNOSTICS: -UNUSED_PARAMETER
// !EXPLICIT_FLEXIBLE_TYPES
// !CHECK_TYPE

fun foo(f: ft<Int, Int?>) {
    f.checkType { <!INAPPLICABLE_CANDIDATE!>_<!><Int>() }
    f.checkType { <!INAPPLICABLE_CANDIDATE!>_<!><Int?>() }
}