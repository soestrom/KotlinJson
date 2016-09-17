import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Christian on 17/09/2016.
 */
class JsonTest {
    @Test
    fun shouldGetString() {
        val json = Json("String")
        assertEquals("String", json.string)
    }

    @Test
    fun shouldBeAString() {
        val json = Json("String")
        assertNull(json.jsonObject)
        assertNull(json.int)
        assertNull(json.boolean)
        assertNull(json.double)
    }

    @Test
    fun shouldGetInt() {
        val json = Json(10)
        assertEquals(10, json.int)
    }

    @Test
    fun shouldBeAnInt() {
        val json = Json(10)
        assertNull(json.jsonObject)
        assertNull(json.string)
        assertNull(json.boolean)
        assertNull(json.double)
    }

    @Test
    fun shouldGetBoolean() {
        val json = Json(true)
        assertEquals(true, json.boolean)
    }

    @Test
    fun shouldBeABoolean() {
        val json = Json(true)
        assertNull(json.jsonObject)
        assertNull(json.string)
        assertNull(json.int)
        assertNull(json.double)
    }

    @Test
    fun shouldGetDouble() {
        val json = Json(1.234)
        assertEquals(1.234, json.double)
    }

    @Test
    fun shouldBeADouble() {
        val json = Json(1.234)
        assertNull(json.jsonObject)
        assertNull(json.string)
        assertNull(json.int)
        assertNull(json.boolean)
    }

    @Test
    fun shouldUseDoubleGetNotation() {
        val map = mapOf<String, Any>("key" to mapOf<String, Any>("key" to "InnerObject"))
        val json = Json(map)
        val innerObejct = json["key"]["key"]
        assertEquals("InnerObject", innerObejct.string)
    }
}