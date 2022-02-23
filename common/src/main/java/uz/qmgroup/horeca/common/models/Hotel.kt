package uz.qmgroup.horeca.common.models

data class Hotel(
    val title: String = "",
    val city: String = "",
    val stars: Int = 0,
    val rating: Float = 0f,
    val address: String = "",
    val distanceToIt: Long = 0L,
    val price: Float = 0f,
    val comment: String = "",
    val abilities: List<String> = emptyList(),
    val imageUrl: String = ""
)
