package org.danieer.com.entities

class Prestamo(
    private val fechaEntrega: String,
    private val book: Book
) {
    fun showData(): String {
        return "$fechaEntrega ${book.getFullData()}"
    }
}