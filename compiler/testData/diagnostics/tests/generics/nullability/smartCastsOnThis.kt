// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_EXPRESSION,-UNUSED_VARIABLE

fun <T : CharSequence?> T.bar1() {}
fun CharSequence?.bar2() {}

fun <T : CharSequence> T.bar3() {}
fun CharSequence.bar4() {}

fun <T : String?> T.foo() {
    if (this != null) {
        if (<!SENSELESS_COMPARISON!>this != null<!>) {}

        <!NI;DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>length<!>
        this<!UNNECESSARY_SAFE_CALL!>?.<!>length

        <!NI;DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>bar1<!>()
        bar2()
        <!NI;DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST, OI;TYPE_INFERENCE_UPPER_BOUND_VIOLATED!>bar3<!>()
        <!NI;DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>bar4<!>()


        this<!UNNECESSARY_SAFE_CALL!>?.<!>bar1()
    }

    <!UNSAFE_CALL!>length<!>

    if (this is String) {
        <!DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>length<!>
        this<!UNNECESSARY_SAFE_CALL!>?.<!>length

        <!NI;DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST!>bar1<!>()
        bar2()
        <!NI;DEBUG_INFO_IMPLICIT_RECEIVER_SMARTCAST, OI;TYPE_INFERENCE_UPPER_BOUND_VIOLATED!>bar3<!>()
    }
}