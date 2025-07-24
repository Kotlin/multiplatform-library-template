package io.github.hesamedin.logger

import kotlin.test.Test
import kotlin.test.assertEquals

class IosFibiTest {

    @Test
    fun `test 3rd element`() {
        assertEquals(7, generateFibi().take(3).last())
    }
}