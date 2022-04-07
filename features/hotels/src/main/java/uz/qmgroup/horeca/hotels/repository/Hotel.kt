package uz.qmgroup.horeca.hotels.repository

import uz.qmgroup.horeca.common.models.BaseObjectModel

data class Hotel(
    override val id: Long = 0,
    override val title: String = "",
    override val city: String = "",
    override val stars: Int = 0,
    override val rating: Float = 0f,
    override val address: String = "",
    override val phone: String? = null,
    override val distanceToIt: Long = 0L,
    override val imageUrl: String = "",
    val price: Float = 0f,
    val abilities: List<String> = emptyList(),
    val wifi: Boolean = true,
    val restaurant: Boolean = false,
    val pool: Boolean = false,
    val gym: Boolean = false,
    val tariffs: List<String> = emptyList()
): BaseObjectModel(

)
