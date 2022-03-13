package uz.qmgroup.horeca.common.models

open class BaseObjectModel(
    open val id: Long = 0,
    open val title: String = "",
    open val city: String = "",
    open val stars: Int = 0,
    open val rating: Float = 0f,
    open val address: String = "",
    open val phone: String? = null,
    open val distanceToIt: Long = 0L,
    open val imageUrl: String = "",
)
