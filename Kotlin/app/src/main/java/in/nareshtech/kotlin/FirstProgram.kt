package `in`.nareshtech.kotlin

fun main() {
    // Data type can be specified, however as there is typeInference, we need not to write it while we assign a val
   val a:Int = 10 //immutable
    var b = 11.5 //mutable
    b = 12.6
    val s = describe(12)
    print(s)
}

fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }