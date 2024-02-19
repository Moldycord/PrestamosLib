package org.danieer.com.ui

import org.danieer.com.entities.Book
import org.danieer.com.utils.DataReader
import org.danieer.com.utils.Printer

class BookController {

    private val printer = Printer()
    private val dataReader = DataReader()
    private val bookList = mutableListOf(
        Book(
            "El Caballero de la armadura oxidada",
            "Robert Fisher",
            "WU32939KDI"
        )
    )

    fun registerBook() {
        printer.apply {
            printMsg("¿Cuál es el titulo")
            val title = dataReader.readString()
            printMsg("¿Cuál es el autor?")
            val author = dataReader.readString()
            printMsg("Ingrese el ISBN")
            val isbn = dataReader.readString()
            bookList.add(Book(title, author, isbn))
        }
    }

    fun showBooks() {
        println("Libros disponibles:")
        var counter = 1
        for (book in bookList) {
            println("$counter " + book.getFullData())
            counter++
        }
    }

    fun getBookByIndex(index: Int): Book = bookList[index]

    fun hasAddedBooks(): Boolean = bookList.isEmpty().not()
}