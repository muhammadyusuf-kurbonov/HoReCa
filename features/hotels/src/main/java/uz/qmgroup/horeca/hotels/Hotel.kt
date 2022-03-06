package uz.qmgroup.horeca.hotels

data class Hotel(
    val id: Long = 0,
    val title: String = "",
    val city: String = "",
    val stars: Int = 0,
    val rating: Float = 0f,
    val address: String = "",
    val phone: String? = null,
    val distanceToIt: Long = 0L,
    val price: Float = 0f,
    val comment: String = "",
    val abilities: List<String> = emptyList(),
    val imageUrl: String = "",
    val wifi: Boolean = true,
    val restaurant: Boolean = false,
    val pool: Boolean = false,
    val gym: Boolean = false,
    val tariffs: List<String> = emptyList()
)
