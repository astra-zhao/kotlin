fun test(s: String?) {
    val x: Any = if (s == null) {
        ""
    }
    else {
        <caret>Unit
    }
}