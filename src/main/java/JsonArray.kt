/**
 * Created by Christian on 17/09/2016.
 */
data class JsonArray(private val values: List<Any>): Collection<Json> {
    val jsonValues: List<Json>

    operator fun get(index: Int): Json {
        if (index >= jsonValues.size) return Json()
        return jsonValues[index]
    }

    override val size: Int
        get() = values.size

    init {
        jsonValues = values.map { Json(it) }
    }

    override fun contains(element: Json): Boolean = jsonValues.contains(element)

    override fun containsAll(elements: Collection<Json>): Boolean = jsonValues.containsAll(elements)

    override fun isEmpty(): Boolean = jsonValues.isEmpty()

    override fun iterator(): Iterator<Json> = jsonValues.iterator()
}