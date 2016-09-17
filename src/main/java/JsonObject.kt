import java.util.*

/**
 * Created by Christian on 17/09/2016.
 */

data class JsonObject(val json: Map<String, Any>) {
    operator fun get(key: String): Json {
        val value = json[key]
        return if (value != null) Json(value) else Json()
    }
}
