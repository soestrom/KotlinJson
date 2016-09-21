import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Christian on 17/09/2016.
 */
class JsonObjectTest {

    @Test
    fun shouldGetJson() {
        val jsonObject = JsonObject(mapOf("Key" to "Value"))
        assert(jsonObject["Key"] is Json)
    }

    @Test
    fun shouldContainString() {
        val jsonObject = JsonObject(mapOf("Key" to "Value"))
        assertEquals("Value", jsonObject["Key"].string)
    }

    @Test
    fun shouldContainInt() {
        val jsonObject = JsonObject(mapOf("Key" to 1))
        assertEquals(1, jsonObject["Key"].int)
    }

    @Test
    fun shouldContainObject() {
        val map = mapOf<String, Any>("InnerKey" to "Any")
        val jsonObject = JsonObject(mapOf("Key" to map))

        val innerObject = JsonObject(map)
        assertEquals(innerObject, jsonObject["Key"].jsonObject)
    }

    @Test
    fun shouldContainBoolean() {
        val jsonObject = JsonObject(mapOf("Key" to true))
        assertEquals(true, jsonObject["Key"].boolean)
    }

    @Test
    fun shouldContainArray() {
        val array: List<Any> = listOf(1, 2, 3)
        val jsonObject = JsonObject(mapOf("Key" to array))

        val jsonArray = JsonArray(array)
        assertEquals(jsonArray, jsonObject["Key"].array)
    }

    @Test
    fun shouldGetAtIndex() {
        val jsonObject = JsonObject(mapOf("name" to "Peter", "age" to 21, "gender" to "Male"))
        assertEquals("Peter", jsonObject[0].string)
        assertEquals(21, jsonObject[1].int)
        assertEquals("Male", jsonObject[2].string)
        assertNull(jsonObject[3].string)
    }

    @Test
    fun shouldAddElement() {
        val jsonObject = JsonObject()
        jsonObject["name"] = "Peter"
        jsonObject["age"] = 21

        assertEquals("Peter", jsonObject["name"].string)
        assertEquals(21, jsonObject["age"].int)
    }
}
