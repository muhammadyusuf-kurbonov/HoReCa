package uz.qmgroup.horeca.common

fun <E> List<E>.getFirst(count: Int): List<E> {
    return try {
        subList(0, count)
    } catch (e: IndexOutOfBoundsException){
        this
    }
}