package uz.qmgroup.horeca.common.comments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.common.BaseViewModel
import uz.qmgroup.horeca.common.models.Comment

abstract class BaseCommentsViewModel<E> : BaseViewModel<E>() {
    var rating: Int by mutableStateOf(0)
        private set
    var fullName: String by mutableStateOf("")
        private set
    var phone: String by mutableStateOf("")
        private set
    var comment: String by mutableStateOf("")
        private set

    fun updateRating(rating: Int) {
        this.rating = rating
    }

    fun updateFullName(name: String) {
        this.fullName = name
    }

    fun updatePhone(phone: String) {
        this.phone = phone
    }

    fun updateComment(comment: String) {
        this.comment = comment
    }

    fun saveReview(id: Long){
        viewModelScope.launch {
            getRepo().saveComment(
                Comment(
                    objectId = id,
                    objectType = "",
                    authorName = fullName,
                    phone = phone,
                    comment = comment
                )
            )
        }
    }
}