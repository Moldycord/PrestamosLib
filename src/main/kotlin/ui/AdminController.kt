package org.danieer.com.ui

import org.danieer.com.utils.DataReader
import org.danieer.com.utils.Printer

class AdminController {

    private val registerStudents = RegisterStudent()
    private val dataReader = DataReader()
    private val bookController = BookController()
    private val prestamosController = PrestamosController()
    private val printer = Printer()

    fun showMenu() {
        printer.apply {
            printMsg("")
            printMsg("Bienvenido a la administración de Préstamos")
            printMsg("Ingrese una opción")
            printMsg("1.- Registrar estudiante")
            printMsg("2.- Mostrar estudiantes")
            printMsg("3.- Registrar libro")
            printMsg("4.- Mostrar libros")
            printMsg("5.- Registrar préstamo")
        }

        val selectedOption = dataReader.readInt()

        when (selectedOption) {
            1 -> {
                registerStudents.registerStudent()
                showMenu()
            }

            2 -> {
                registerStudents.showStudents(true)
                showMenu()
            }

            3 -> {
                bookController.registerBook()
                showMenu()
            }

            4 -> {
                bookController.showBooks()
                showMenu()
            }

            5 -> registerPrestamo()
            6 -> {
                prestamosController.showPrestamos()
                showMenu()
            }
        }
    }

    private fun registerPrestamo() {

        if (!registerStudents.hasAddedStudents()) {
            println("Deben existir alumnos registrados para poder crear un préstamo")
            showMenu()

        } else if (!bookController.hasAddedBooks()) {
            println("Debe ingresar un libro")
            showMenu()
        } else {

            printer.apply {
                printMsg("Seleccione un libro de la lista")
                bookController.showBooks()
                val selectedBookInt = dataReader.readInt()
                val selectedBook = bookController.getBookByIndex(selectedBookInt - 1)
                printMsg("Seleccione un alumno de la lista")
                registerStudents.showStudents(false)
                val selectedStudentIndex = dataReader.readInt()
                val selectedStudent = registerStudents.getStudentByIndex(selectedStudentIndex - 1)
                printMsg("Ingrese la fecha de devolución")
                val fechaEntrega = dataReader.readString()
                prestamosController.createPrestamo(selectedStudent, selectedBook, fechaEntrega)
            }

            showMenu()
        }


    }
}