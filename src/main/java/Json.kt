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

    val jsonObject: JsonObject?
        get() {
            if (value !is Map<*, *>) return null

            val map: Map<String, Any> = mapper.convertValue(value, JsonParser.JsonMapType())
            return JsonObject(map)
        }

    val array: JsonArray?
        get() {
            if (value !is List<*>) return null

            val array: List<Any> = mapper.convertValue(value, JsonParser.JsonArrayType())
            return JsonArray(array)
        }

    val string: String?
        get() = value as? String

    val int: Int?
        get() = value as? Int

    val boolean: Boolean?
        get() = value as? Boolean

    val double: Double?
        get() = value as? Double
}
