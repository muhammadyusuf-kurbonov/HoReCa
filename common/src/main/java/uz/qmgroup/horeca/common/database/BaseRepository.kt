package uz.qmgroup.horeca.common.database

interface BaseRepository<E> {
    suspend fun getAll(): List<E>

    suspend fun get(id: Long): E

    suspend fun search(query: String): List<E>
}