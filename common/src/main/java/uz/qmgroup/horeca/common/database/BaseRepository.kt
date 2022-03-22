package uz.qmgroup.horeca.common.database

import uz.qmgroup.horeca.common.models.Comment

interface BaseRepository<E> {
    suspend fun getAll(): List<E>

    suspend fun get(id: Long): E

    suspend fun search(query: String): List<E>

    suspend fun saveComment(comment: Comment)

    suspend fun getComments(): List<Comment>
}