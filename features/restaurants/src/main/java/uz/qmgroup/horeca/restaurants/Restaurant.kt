package uz.qmgroup.horeca.restaurants

import uz.qmgroup.horeca.common.models.BaseObjectModel

data class Hour(
    val hour: Int,
    val minute: Int
)

class Restaurant(
    override val id: Long,
    override val title: String = "",
    override val city: String = "",
    override val stars: Int = 0,
    override val rating: Float = 0f,
    override val address: String = "",
    override val phone: String? = null,
    override val distanceToIt: Long = 0L,
    override val imageUrl: String = "",
    val comment: String = "",
    val workTime: Pair<Hour, Hour> = Hour(9, 0) to Hour(17, 0),
    val areas: List<String> = emptyList()
): BaseObjectModel()