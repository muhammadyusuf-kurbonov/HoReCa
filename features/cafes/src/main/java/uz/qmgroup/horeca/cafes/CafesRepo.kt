package uz.qmgroup.horeca.cafes

import uz.qmgroup.horeca.common.database.BaseRepository

class CafesRepo: BaseRepository<Cafe> {
    private val items = listOf(
        Cafe(
            id = 0,
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            imageUrl = "https://scontent.fura3-1.fna.fbcdn.net/v/t39.30808-6/250711322_1342578302828371_1652172121947662843_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=e3f864&_nc_ohc=Q3s6AaWgU4kAX_um2qI&tn=8yHEvfaa0zekyd4_&_nc_ht=scontent.fura3-1.fna&oh=00_AT8R2WZ1rhJ_uYqFlMW2BoDwmtYd-GBANQfvSPsIeKxREw&oe=6220CB00",
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

}