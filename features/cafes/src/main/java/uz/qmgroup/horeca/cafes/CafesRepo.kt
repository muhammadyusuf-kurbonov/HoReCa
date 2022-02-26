package uz.qmgroup.horeca.cafes

import uz.qmgroup.horeca.common.database.BaseRepository

class CafesRepo: BaseRepository<Cafe> {
    override suspend fun getAll(): List<Cafe> = listOf(
        Cafe(
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            comment = "Hi. Best Restaurant",
            distanceToIt = 5L,
        ),
        Cafe(
            title = "Big Hall",
            city = "Tashkent",
            rating = 3.5f,
            stars = 4,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        ),
        Cafe(
            title = "Big Hall",
            city = "Tashkent",
            rating = 5f,
            stars = 3,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        )
    )

}