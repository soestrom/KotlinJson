import java.util.*

/**
 * Created by Christian on 17/09/2016.
 */

data class JsonObject(private var initialvalues: Map<String, Any> = mapOf()) {
    val json: MutableMap<String, Any> = mutableMapOf()
    init {
        initialvalues.forEach { json[it.key] = it.value }
    }

    /**
     * @param key The key for the corresponding value.
     * @return The Json element for the key. If the key does not exist an empty Json element is returned.
     */
    operator fun get(key: String): Json {
        val value = json[key]
        return if (value != null) Json(value) else Json()
    }

    operator fun get(index: Int): Json {
        val values = json.values.toList()
        if (values.size <= index)
            return Json()

        return Json(values[index])
    }

    operator fun set(key: String, value: Any) {
        json[key] = value
    }

    fun exists(key: String): Boolean = json[key] == null
}
