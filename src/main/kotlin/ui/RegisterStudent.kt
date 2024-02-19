package org.danieer.com.ui

import org.danieer.com.entities.Student
import org.danieer.com.utils.DataReader
import org.danieer.com.utils.Printer

class RegisterStudent {

    private val studentList = mutableListOf<Student>()
    private val dataReader = DataReader()
    private val printer = Printer()

    fun registerStudent() {
        dataReader.apply {
            printer.printMsg("Ingrese el nombre")
            val names = readString()
            printer.printMsg("Ingrese el apellido paterno")
            val firstLastName = readString()
            printer.printMsg("Ingrese el apellido materno")
            val secondLastName = readString()
            printer.printMsg("Ingrese la matricula")
            val enrollmentId = readLong()
            val addedStudent = Student(
                names, firstLastName, secondLastName, enrollmentId
            )
            studentList.add(addedStudent)

            println("Estudiante registrado exitosamente")
        }

    }

    fun getStudentByIndex(index: Int): Student = studentList[index]

    fun showStudents(showPrestamos: Boolean) {
        var counter = 1
        for (student in studentList) {
            println("$counter " + student.getFullData())
            println("Prestamos registrados de ${student.names}")
            if (showPrestamos) {
                student.showPrestamos()
            }
            counter++
        }
    }

    fun hasAddedStudents(): Boolean = studentList.isEmpty().not()
}