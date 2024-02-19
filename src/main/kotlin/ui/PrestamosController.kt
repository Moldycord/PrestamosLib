package org.danieer.com.ui

import org.danieer.com.entities.Book
import org.danieer.com.entities.Prestamo
import org.danieer.com.entities.Student

class PrestamosController {

    private val prestamosList = mutableListOf<Prestamo>()
    fun createPrestamo(student: Student, book: Book, fechaEntrega: String) {

        val prestamo = Prestamo(fechaEntrega, book)

        prestamosList.add(prestamo)
        student.addPrestamo(prestamo)
        showPrestamos()
    }

    fun showPrestamos() {
        for (prestamo in prestamosList) {
            println(prestamo.showData())
        }
    }
}