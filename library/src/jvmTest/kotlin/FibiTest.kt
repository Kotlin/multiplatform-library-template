import kotlin.test.Test
import kotlin.test.assertEquals

class FibiTest {
    @Test
    fun `test 3rd element`(){
       assertEquals(5, fibi.take(3).last())
    }
}