import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Christian on 17/09/2016.
 */

class JsonParserTest {

    @Test
    fun shouldParseJsonString() {
        val jsonString = "{ \"name\": \"Christian\" }"
        val json = JsonParser.parse(jsonString)

        assertNotNull(json)
    }

    @Test
    fun shouldParseJsonObject() {
        val jsonString = "{ \"name\": \"Christian\" }"
        val json = JsonParser.parse(jsonString)

        assertNotNull(json)

        val jsonObject = json.jsonObject
        assertNotNull(jsonObject)

        val name = if (jsonObject != null) jsonObject["name"].string else null
        assert(name?.equals("Christian") == true)
    }

    @Test
    fun shouldParseNestedObjects() {
        val jsonString = "{ \"object\": { \"name\": \"Christian\" } }"
        val json = JsonParser.parse(jsonString)

        val jsonObject = json.jsonObject ?: return fail()
        val innerObject = jsonObject["object"].jsonObject ?: return fail()

        assertEquals("Christian", innerObject["name"].string)
    }

    @Test
    fun shouldParseString() {
        val jsonString = "{ \"name\": \"Christian\" }"
        val json = JsonParser.parse(jsonString)

        val jsonObject = json.jsonObject ?: return fail()
        assertEquals("Christian", jsonObject["name"].string)
    }

    @Test
    fun shouldParseInt() {
        val jsonString = "{ \"number\": 1 }"
        val json = JsonParser.parse(jsonString)

        val jsonObject = json.jsonObject ?: return fail()
        assertEquals(1, jsonObject["number"].int)
    }

    @Test
    fun shouldParseBoolean() {
        val jsonString = "{ \"boolean\": true }"
        val json = JsonParser.parse(jsonString)

        val jsonObject = json.jsonObject ?: return fail()
        assertEquals(true, jsonObject["boolean"].boolean)
    }

    @Test
    fun shouldParseDouble() {
        val jsonString = "{ \"number\": 1.234 }"
        val json = JsonParser.parse(jsonString)

        val jsonObject = json.jsonObject ?: return fail()
        assertEquals(1.234, jsonObject["number"].double)
    }

    @Test
    fun shouldParseArray() {
        val jsonString = "{ \"numbers\": [1, 2, 3] }"
        val json = JsonParser.parse(jsonString)

        val jsonObject = json.jsonObject ?: return fail()
        val array = jsonObject["numbers"].array ?: return fail()

        val values = arrayOf(1, 2, 3)
        array.forEachIndexed { index, json -> assertEquals(values[index], json.int) }
    }
}