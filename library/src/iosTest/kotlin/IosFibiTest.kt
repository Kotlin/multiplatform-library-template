import kotlin.test.Test
import kotlin.test.assertEquals

class IosFibiTest {

    @Test
    fun `test 3rd element`() {
        assertEquals(7, fibi.take(3).last())
    }
}