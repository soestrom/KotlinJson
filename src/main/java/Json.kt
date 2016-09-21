import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Christian on 17/09/2016.
 */
data class Json(private val value: Any = Any()) {
    private val mapper = ObjectMapper()

    operator fun get(key: String): Json {
        val currentObject = jsonObject ?: return Json()
        return currentObject[key]
    }

    /**
     * Gives a json object from String to Json.
     */
    val jsonObject: JsonObject?
        get() {
            if (value !is Map<*, *>) return null

            val map: Map<String, Any> = mapper.convertValue(value, JsonParser.JsonMapType())
            return JsonObject(map)
        }
    /**
     * Gives a json array of Json.
     */
    val array: JsonArray?
        get() {
            if (value !is List<*>) return null

            val array: List<Any> = mapper.convertValue(value, JsonParser.JsonArrayType())
            return JsonArray(array)
        }

    /**
     * Gives a String if the value is a String else null
     */
    val string: String?
        get() = value as? String

    /**
     * Gives a Int if the value is a Int else null
     */
    val int: Int?
        get() = value as? Int

    /**
     * Gives a Boolean if the value is a Boolean else null
     */
    val boolean: Boolean?
        get() = value as? Boolean

    /**
     * Gives a Double if the value is a Double else null
     */
    val double: Double?
        get() = value as? Double
}
