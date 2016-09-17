import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Christian on 17/09/2016.
 */
object JsonParser {
    val mapper = ObjectMapper()

    fun parse(string: String): Json {
        val value: Map<String, Any> = mapper.readValue(string, JsonMapType())
        return Json(value)
    }

    class JsonMapType: TypeReference<Map<String, Any>>() {}

    class JsonArrayType: TypeReference<List<Any>>() {}
}