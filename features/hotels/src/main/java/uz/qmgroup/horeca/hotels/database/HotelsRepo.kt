package uz.qmgroup.horeca.hotels.database

import uz.qmgroup.horeca.hotels.Hotel

class HotelsRepo {
    suspend fun getAllHotels() = listOf(
        Hotel(
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            price = 120f,
            wifi = true
        ),
        Hotel(
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
}