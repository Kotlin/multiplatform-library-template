package io.github.kotlin.fibonacci

import kotlin.test.Test
import kotlin.test.assertEquals

class FibiTest {
    @Test
    fun `test 5th element`() {
        assertEquals(3, generateFibi().take(4).last())
    }

    @Test
    fun `test 8th element`() {
        assertEquals(13, generateFibi().take(7).last())
    }
}
