package com.algoexpert.playground

import java.util.Collections


data class StudentComparator(val id: Int, val name: String)


fun main() {
    val studentList: MutableList<StudentComparator> = ArrayList()
    val student3 = StudentComparator(167, "Thisun")
    val student1 = StudentComparator(327, "Kasun")
    val student2 = StudentComparator(100, "Dasun")

    studentList.add(student1)
    studentList.add(student2)
    studentList.add(student3)
    println("Sorting using id")
    Collections.sort(studentList,IdComparator())
    println("Sorting using name")
    Collections.sort(studentList,NameComparator())
}


class IdComparator : Comparator<StudentComparator> {
    override fun compare(s1: StudentComparator, s2: StudentComparator): Int {
        return if (s2.id == s1.id) {
            0
        } else if (s2.id > s1.id) {
            1
        } else {
            -1
        }
    }

}

class NameComparator : Comparator<StudentComparator> {
    override fun compare(s1: StudentComparator, s2: StudentComparator): Int {
        /**
         * This will check string internally & will return proper values as per need
         *
         */
        return s2.name.compareTo(s1.name)
    }


}