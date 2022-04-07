package uz.qmgroup.horeca.cafes

import uz.qmgroup.horeca.cafes.repository.Cafe
import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.common.models.Comment

class CafesRepo: BaseRepository<Cafe> {
    private val items = listOf(
        Cafe(
            id = 0,
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            imageUrl = "https://media-cdn.tripadvisor.com/media/photo-s/10/e5/73/92/photo1jpg.jpg",
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            comment = "Hi. Best Restaurant",
            distanceToIt = 5L,
            phone = "+998913975538",
            areas = listOf(
                "Umumiy joy",
                "VIP",
                "Banketlar zali"
            )
        ),
        Cafe(
            id = 1,
            title = "Big Hall",
            city = "Tashkent",
            rating = 3.5f,
            stars = 4,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        ),
        Cafe(
            id = 2,
            title = "Big Hall",
            city = "Tashkent",
            rating = 5f,
            stars = 3,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        )
    )

    override suspend fun get(id: Long): Cafe = items[id.toInt()]

    override suspend fun getAll(): List<Cafe> = items
    override suspend fun search(query: String): List<Cafe> {
        return items.filter {
            it.title.contains(query) or it.address.contains(query)
        }
    }

    override suspend fun saveComment(comment: Comment) {
        TODO("Not yet implemented")
    }

    override suspend fun getComments(): List<Comment> {
        TODO("Not yet implemented")
    }

}