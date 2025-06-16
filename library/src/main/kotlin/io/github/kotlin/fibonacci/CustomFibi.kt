package io.github.kotlin.fibonacci

fun generateFibi(): Sequence<Int> = sequence {
    var a = 1
    var b = 1
    while (true) {
        yield(a)
        val next = a + b
        a = b
        b = next
    }
}
