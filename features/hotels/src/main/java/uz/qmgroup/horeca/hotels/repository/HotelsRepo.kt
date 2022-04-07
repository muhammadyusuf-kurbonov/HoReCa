package uz.qmgroup.horeca.hotels.repository

import com.google.gson.Gson
import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.common.models.Comment

class HotelsRepo : BaseRepository<Hotel> {
    private val json = """
        [
          {
            "title": "\u041e\u0442\u0435\u043b\u044c \u0423\u0437\u0431\u0435\u043a\u0438\u0441\u0442\u0430\u043d", 
            "mode_info": "/hotel/uz/hotel-uzbekistan-tashkent.ru.html", 
            "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/130518921.jpg?k=c42e1313b6e8a2330acde69eb1c0869edb988b06c26c0d0721af78e65582a70c&o=", 
            "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", 
            "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", 
            "review_score": "6,6", 
            "reviews": "719 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"
          }, 
          {"title": "City Palace Hotel Tashkent4 \u0437\u0432\u0435\u0437\u0434", "mode_info": "/hotel/uz/city-palace-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/176420461.jpg?k=feb0faf335c5fef9354915549010b671e52cc077c025f1df9d24cc1d4687d623&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "review_score": "8,0", "reviews": "833 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Hyatt Regency Tashkent5 \u0437\u0432\u0435\u0437\u0434", "mode_info": "/hotel/uz/hyatt-regency-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/87360561.jpg?k=79c94f9bd105388382fa2731be6b153ad15d42f075088b6d319531f75824e3d2&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "review_score": "9,2", "reviews": "779 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Leader Hotel", "mode_info": "/hotel/uz/leader.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/209544039.jpg?k=1978498cba30fa17b96972454881c2640d8c1ebc4715c3a1b6188500c1dce5dd&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "review_score": "8,5", "reviews": "278 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Hilton Tashkent City5 \u0437\u0432\u0435\u0437\u0434", "mode_info": "/hotel/uz/hilton-tashkent-city.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/247363645.jpg?k=a353a01736807af62db2b1e65bfcb3bc87d0401a29501813d07b9213d10af114&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "review_score": "9,0", "reviews": "422 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Pakhtakor Athletics hotel", "mode_info": "/hotel/uz/pakhtakor-athletics.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/221584306.jpg?k=e1d043d385933ad057989b56b3a846a85811517a5186288c3bf1b1b3d8d314fe&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u042d\u0442\u043e\u0442 \u043e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435 \u0437\u0430\u0431\u0440\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u043b\u0438 254 \u0440\u0430\u0437\u0430", "review_score": "8,9", "reviews": "114 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Hotel Inspira-S Tashkent4 \u0437\u0432\u0435\u0437\u0434", "mode_info": "/hotel/uz/inspira-s-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/302029617.jpg?k=16ed39fd8f176ab87b8bf5223432d3f0ae87249fdf08cb765827f15ee04525ab&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u042d\u0442\u043e\u0442 \u043e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435 \u0437\u0430\u0431\u0440\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u043b\u0438 252 \u0440\u0430\u0437\u0430", "review_score": "9,7", "reviews": "34 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "ATECA Hotel Suites Tashkent", "mode_info": "/hotel/uz/ateca-suites.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/310682729.jpg?k=6c6368889f343dbba4d64cb0c3fe730dddc97f6cc90eb3ca115155d2000d46b8&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "review_score": "9,5", "reviews": "251 \u043e\u0442\u0437\u044b\u0432"}, {"title": "Hampton By Hilton Tashkent", "mode_info": "/hotel/uz/hampton-by-hilton-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/327168290.jpg?k=4438e12954ddd6399e4ff8c6ba6ca907fc25585289417048af72144c2b7d07d8&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u041f\u043e\u043f\u0443\u043b\u044f\u0440\u043d\u043e \u0441\u0440\u0435\u0434\u0438 \u0433\u043e\u0441\u0442\u0435\u0439, \u0431\u0440\u043e\u043d\u0438\u0440\u0443\u044e\u0449\u0438\u0445 \u043e\u0442\u0435\u043b\u0438 \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "review_score": "9,3", "reviews": "86 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Sapiens Hotel", "mode_info": "/hotel/uz/sapiens.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/345224905.jpg?k=f9ee42dd2bd96809050a9c2187f83a4f7fc9418f7a0558ccbf0cdb40b638268a&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "\u042d\u0442\u043e\u0442 \u043e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435 \u0437\u0430\u0431\u0440\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u043b\u0438 373 \u0440\u0430\u0437\u0430", "review_score": "9,5", "reviews": "151 \u043e\u0442\u0437\u044b\u0432"}, {"title": "Hilton Tashkent City", "mode_info": "/hotel/uz/hilton-tashkent-city.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/247363645.jpg?k=a353a01736807af62db2b1e65bfcb3bc87d0401a29501813d07b9213d10af114&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,0", "reviews": "422 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Chinor Garden Hotel", "mode_info": "/hotel/uz/chinor-garden-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/234019351.jpg?k=404dddb386c5b941393704cec0a07a4f776b26df4aa2108e2768a117add5c4e5&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,2", "reviews": "104 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "The Royal Mezbon Hotel & SPA", "mode_info": "/hotel/uz/the-royale-mezbon.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/208881127.jpg?k=e5f156119aa7ed237ef68557463882084cc0ce4b7cad8583bba22c44c0c908fc&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,1", "reviews": "620 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Navruz Hotel Tashkent", "mode_info": "/hotel/uz/navruz.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/284226034.jpg?k=d30cb28831dede62f398d99af392367e6df6758662e1f53a7c35e54fc23f17dd&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,1", "reviews": "494 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Hyatt Regency Tashkent", "mode_info": "/hotel/uz/hyatt-regency-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/87360561.jpg?k=79c94f9bd105388382fa2731be6b153ad15d42f075088b6d319531f75824e3d2&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,2", "reviews": "779 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Ichan Qal'a Premium Class Hotel", "mode_info": "/hotel/uz/ichanqala-villas.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/319177515.jpg?k=5bd693c37e87940ea8b5fa15a6c13715d81abb6e15776a4c3cf1de659c802ce4&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,0", "reviews": "474 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "THE TIME HOTEL", "mode_info": "/hotel/uz/the-time.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/342846322.jpg?k=42777fb40b44336e6218174a505fa709224680da2ace67f5d4a6037e277b4402&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,4", "reviews": "13 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Bristol Hotel Tashkent", "mode_info": "/hotel/uz/bristol-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/335749899.jpg?k=829b5968ba6cac1ce8a1a796601b8cc2dc202ca8ca9d50a605e58aa1b92ca613&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "10", "reviews": "5 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Corner Hotel Tashkent", "mode_info": "/hotel/uz/corner.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/243896843.jpg?k=9031decdae8572e8eeed909795152132eb8bce0cf3598c847a350a470e860af2&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,1", "reviews": "132 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Qushbegi Plaza Hotel", "mode_info": "/hotel/uz/qushbegi-plaza.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/245312254.jpg?k=ff555bc22d1e66d6f4d2e725d1b37258b375b27c0aa9acba49ee8ae0d049dfb7&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,4", "reviews": "114 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "City Centre Hotel", "mode_info": "/hotel/uz/city-center.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/260878003.jpg?k=6bcf89c5f9a47106ca0ba85db537ce8713c97575b6e8ad284e814c265f19572f&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,4", "reviews": "201 \u043e\u0442\u0437\u044b\u0432"}, {"title": "ART ECO HOTEL", "mode_info": "/hotel/uz/art-eco.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/221582922.jpg?k=34e9d36ac5fb94fc153d76465966d9b586ade1fb4e044fed105c2a359489f2cf&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,6", "reviews": "624 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Home Boutique Hotel", "mode_info": "/hotel/uz/home-toshkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/245393549.jpg?k=579942cdb94f6824e644973000daa91cbfc1283f00b3e5b97d42941376eb3f1e&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,6", "reviews": "225 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Simma Hotel Spa & Waterpark", "mode_info": "/hotel/uz/simma-spa-amp-waterpak.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/311709326.jpg?k=1be2d1b0ee913da1b99f209fdd60c6882abc6126b20cbeab86881216e3dd5ca5&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,1", "reviews": "285 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Praga Hotel", "mode_info": "/hotel/uz/praga-tashkent1.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/194731633.jpg?k=ccd1096e475139ccb6384035fe0b1f4dffc77593cd0cc4a63584108f125dee84&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,1", "reviews": "272 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Mirzo Boutique Hotel", "mode_info": "/hotel/uz/mirzo-toshkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/196099136.jpg?k=c7fc4cfd7485b4c4707cb0de2695029ce56793bc11a8eaa11695a82c7417be11&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,5", "reviews": "485 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Grand Moffah hotel", "mode_info": "/hotel/uz/grand-moffah.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/345558924.jpg?k=671a56b13498b05258a895a31174c14916dd9b40c5e98091cdf8d6b83198c496&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "10", "reviews": "3 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Kora Kum HOTEL", "mode_info": "/hotel/uz/kora-kum-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/311925763.jpg?k=4707e02aeff590b84a32fde7aa5d2f0771ff5a21d36d85dc63aa88dfb1dff5aa&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "10", "reviews": "1 \u043e\u0442\u0437\u044b\u0432"}, {"title": "Hotel Evita Tashkent", "mode_info": "/hotel/uz/evita-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/344142663.jpg?k=fbc0125a6f32ab7a31ed4e205d7d90cfc2cf46914c2004e5d1e2ca7035c5a157&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "10", "reviews": "1 \u043e\u0442\u0437\u044b\u0432"}, {"title": "Moderno Hotel", "mode_info": "/hotel/uz/city-star.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/338872393.jpg?k=3791abc0cbc04bdf965cef68585f9aa4be1dccd3e3860bc8ce0a036141e49c7e&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,9", "reviews": "211 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}, {"title": "Hotel Inspira-S Tashkent", "mode_info": "/hotel/uz/inspira-s-tashkent.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/302029617.jpg?k=16ed39fd8f176ab87b8bf5223432d3f0ae87249fdf08cb765827f15ee04525ab&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,7", "reviews": "34 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Ridvan Plaza", "mode_info": "/hotel/uz/ridvan-plaza-tashkent1.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/289817879.jpg?k=72e67b523d947b57d37ab496d705b8be43e72f9668f46e6b02e9d0251eb7fd6d&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,7", "reviews": "3 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "The Shahar", "mode_info": "/hotel/uz/the-shahar.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/303654052.jpg?k=1341f21e5b8270a3459133a35ee3d19d7ae98e768d7dc66e9fdffbcdbcab643f&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,4", "reviews": "93 \u043e\u0442\u0437\u044b\u0432\u0430"}, {"title": "Hotel 1946", "mode_info": "/hotel/uz/1946.ru.html", "image": "https://cf.bstatic.com/xdata/images/hotel/270x200/326645514.jpg?k=675075f6486435154e00ad0c00a0704d79b5ecd95cf858f31ff5eda3c7b807f9&o=", "locality": "\u041e\u0442\u0435\u043b\u044c \u0432 \u0422\u0430\u0448\u043a\u0435\u043d\u0442\u0435", "most_booked": "undefined", "review_score": "9,3", "reviews": "99 \u043e\u0442\u0437\u044b\u0432\u043e\u0432"}]
    """.trimIndent()
    private val items = Gson().fromJson(json, Array<HotelDTO>::class.java).mapIndexed { index, item ->  item.toHotel(
        Hotel(id = index.toLong())
    ) }

    override suspend fun get(id: Long): Hotel = items[id.toInt()]

    override suspend fun getAll(): List<Hotel> = items
    override suspend fun search(query: String): List<Hotel> {
        return items.filter { it.title.contains(query) }
    }

    override suspend fun saveComment(comment: Comment) {}

    override suspend fun getComments(): List<Comment> {return emptyList()}
}