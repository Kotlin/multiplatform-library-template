package io.github.kotlin.fibonacci

import kotlin.test.Test
import kotlin.test.assertEquals

class AndroidFibiTest {

    @Test
    fun test_3rd_element() {
        assertEquals(3, generateFibi().take(3).last())
    }
}