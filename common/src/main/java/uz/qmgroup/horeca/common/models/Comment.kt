package uz.qmgroup.horeca.common.models

data class Comment(
    val objectType: String,
    val objectId: Long,
    val authorName: String,
    val comment: String,
    val phone: String,
    val date: Long = System.currentTimeMillis()
)
