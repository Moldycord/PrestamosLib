package org.danieer.com.entities

class Book(
    val title: String,
    val author: String,
    val ISBN: String
) {

    fun getFullData(): String = "$title Autor:$author ISBN:$ISBN"
}