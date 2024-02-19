package org.danieer.com.entities

class Student(

    val names: String,
    val firstLastName: String,
    val secondLastName: String,
    val enrollmentId: Long,
    private val prestamosList: MutableList<Prestamo> = mutableListOf()
) {
    fun getFullData(): String {
        return "Nombre: $firstLastName $secondLastName $names " + "Matricula : $enrollmentId"
    }

    fun showPrestamos() {
        var counter = 1
        for (prestamo in prestamosList) {
            println(prestamo.showData())
            counter++
        }
    }

    fun addPrestamo(prestamo: Prestamo) {
        prestamosList.add(prestamo)
    }
}