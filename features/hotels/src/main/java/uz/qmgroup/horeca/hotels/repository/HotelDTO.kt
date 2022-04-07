package uz.qmgroup.horeca.hotels.repository


import androidx.annotation.Keep

@Keep
data class HotelDTO(
    val image: String, // https://cf.bstatic.com/xdata/images/hotel/270x200/130518921.jpg?k=c42e1313b6e8a2330acde69eb1c0869edb988b06c26c0d0721af78e65582a70c&o=
    val locality: String, // Отель в Ташкенте
    val mode_info: String, // /hotel/uz/hotel-uzbekistan-tashkent.ru.html
    val most_booked: String, // Популярно среди гостей, бронирующих отели в Ташкенте
    val review_score: String, // 6,6
    val reviews: String, // 719 отзывов
    val title: String // Отель Узбекистан
){
    fun toHotel(base: Hotel = Hotel()) = base.copy(
        imageUrl = this.image,
        title = this.title,
        rating = this.review_score.replace(",", ".").toFloatOrNull() ?: 0f,
        city = "Tashkent"
    )
}