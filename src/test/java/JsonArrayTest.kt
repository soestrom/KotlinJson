import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Christian on 17/09/2016.
 */
class JsonArrayTest {
    @Test
    fun shouldGetElement() {
        val jsonArray = JsonArray(listOf("Value"))
        assert(jsonArray[0] is Json)
    }

    @Test
    fun shouldGetNullJsonIfOutOfIndex() {
        val jsonArray = JsonArray(listOf())
        assertNull(jsonArray[0].string)
    }

    @Test
    fun shouldContainString() {
        val jsonArray = JsonArray(listOf("Value"))
        assertEquals("Value", jsonArray[0].string)
    }

    @Test
    fun shouldContainInt() {
        val jsonArray = JsonArray(listOf(1))
        assertEquals(1, jsonArray[0].int)
    }

    @Test
    fun shouldContainBoolean() {
        val jsonArray = JsonArray(listOf(false))
        assertEquals(false, jsonArray[0].boolean)
    }

    @Test
    fun shouldContainDouble() {
        val jsonArray = JsonArray(listOf(1.234))
        assertEquals(1.234, jsonArray[0].double)
    }

    @Test
    fun shouldContain3Elements() {
        val values: List<Any> = listOf(1, 2, 3)
        val jsonArray = JsonArray(values)

        jsonArray.forEachIndexed { i, json -> assertEquals(values[i], json.int) }
    }

    @Test
    fun shouldAddElement() {
        val jsonArray = JsonArray()
        jsonArray += "Peter"

        assertEquals("Peter", jsonArray[0].string)
    }
}