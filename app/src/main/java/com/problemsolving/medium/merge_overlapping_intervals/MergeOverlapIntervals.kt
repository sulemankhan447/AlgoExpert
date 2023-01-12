package com.problemsolving.medium.merge_overlapping_intervals


import java.util.*
import kotlin.Comparator
import kotlin.math.max

fun main() {


    val intervals = listOf(
        listOf(1, 2), listOf(3, 5), listOf(4, 7), listOf(6, 8), listOf(9, 10)
    )
    println(mergeOverlappingIntervals(intervals))

}

//fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {

//    var sortedIntervals =
//        intervals.sortedWith(Comparator<List<Int>> { a, b -> a[0].compareTo(b[0]) })
    Collections.sort(intervals,Comparator<List<Int>> { a, b -> a[0].compareTo(b[0]) })
    val sortedIntervals = intervals.map() { it -> it.toMutableList() }

    val mergedIntervals = mutableListOf<MutableList<Int>>()
    var currentInterval = sortedIntervals[0]
    mergedIntervals.add(currentInterval)
    for (nextInterval in sortedIntervals) {
        val (_, currentIntervalEnd) = currentInterval
        val (nextIntervalStart, nextIntervalEnd) = nextInterval
        if (currentIntervalEnd >= nextIntervalStart) {
            currentInterval[1] = max(currentIntervalEnd, nextIntervalEnd)
        } else {
            currentInterval = nextInterval
            mergedIntervals.add(currentInterval)
        }
    }
    return mergedIntervals
}