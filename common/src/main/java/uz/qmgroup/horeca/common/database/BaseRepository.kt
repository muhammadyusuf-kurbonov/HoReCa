package uz.qmgroup.horeca.common.database

interface BaseRepository<E> {
    suspend fun getAll(): List<E>
}