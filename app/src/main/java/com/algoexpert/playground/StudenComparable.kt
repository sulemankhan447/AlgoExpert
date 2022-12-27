package com.algoexpert.playground

data class StudentComparable(val id: Int, val name: String) : Comparable<StudentComparable> {


    override fun compareTo(other: StudentComparable): Int {
        return if (id == other.id) {
            0
        } else if (id < other.id) {
            -1
        } else {
            1
        }
    }

    override fun toString(): String {
        return "id = ${this.id}, name = ${this.name}"
    }

}


fun main() {

    val studentList: MutableList<StudentComparable> = ArrayList()
    val student3 = StudentComparable(167, "Thisun")
    val student1 = StudentComparable(327, "Kasun")
    val student2 = StudentComparable(100, "Dasun")

    studentList.add(student1)
    studentList.add(student2)
    studentList.add(student3)
    studentList.sort()
    print(studentList)

}

/**
 * Implementation of sorting based on comparable interface
 *here we can sort based upon only one param
 * if requirement changes we have to remove old sorting logic and
 * write new sorting logic based on new param
 *
 * sorting rules
 * 1) if string is equal return 0
 * 2) if string is lesser , return value lesser than 0 which is basically negative value i.e prefeered is -1
 * 3) if string is greater, return value greater than 0 which is basically positive value i.e preferred is +1
 *
 *
 */