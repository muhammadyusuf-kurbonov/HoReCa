package uz.qmgroup.horeca.restaurants

data class Hour(
    val hour: Int,
    val minute: Int
)

class Restaurant(
    val id: Long,
    val title: String = "",
    val city: String = "",
    val stars: Int = 0,
    val rating: Float = 0f,
    val address: String = "",
    val phone: String? = null,
    val distanceToIt: Long = 0L,
    val comment: String = "",
    val workTime: Pair<Hour, Hour> = Hour(9, 0) to Hour(17, 0),
    val imageUrl: String = "",
    val areas: List<String> = emptyList()
)