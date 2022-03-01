package uz.qmgroup.horeca.common.models

data class Review(
    val objectType: String,
    val objectId: Long,
    val authorName: String,
    val comment: String,
    val date: Long = System.currentTimeMillis()
)
