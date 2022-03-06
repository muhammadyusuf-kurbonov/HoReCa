package uz.qmgroup.horeca.hotels.database

import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.hotels.Hotel

class HotelsRepo: BaseRepository<Hotel> {
    private val items = listOf(
        Hotel(
            id = 0,
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            price = 120f,
            wifi = true,
            tariffs = listOf(
                "SemiLUX",
                "Delux",
                "VIP"
            )
        ),
        Hotel(
            id = 1,
            title = "Miras",
            city = "Tashkent",
            rating = 3.5f,
            stars = 4,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            price = 120f,
            wifi = true,
            restaurant = false,
            pool = true
        ),
        Hotel(
            id = 2,
            title = "Big Hall",
            city = "Tashkent",
            rating = 5f,
            stars = 3,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            price = 120f,
            wifi = false,
            restaurant = true,
            gym = true
        )
    )

    override suspend fun get(id: Long): Hotel = items[id.toInt()]
    override suspend fun getAll(): List<Hotel> = items
    override suspend fun search(query: String): List<Hotel> {
        return items.filter {
            it.title.contains(query) or it.address.contains(query)
        }
    }
}