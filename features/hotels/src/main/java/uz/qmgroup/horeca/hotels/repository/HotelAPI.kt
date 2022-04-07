package uz.qmgroup.horeca.hotels.repository

import retrofit2.http.GET

interface HotelAPI {
    @GET("/api/hotels")
    suspend fun getAllHotels(): List<HotelDTO>
}