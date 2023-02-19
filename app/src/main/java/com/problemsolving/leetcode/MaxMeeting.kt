package com.problemsolving.leetcode

import java.util.*

data class Meeting(var start: Int, var end: Int)

/**
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * https://youtu.be/II6ziNnub1Q
 */

fun main() {
    maxMeetings(
        intArrayOf(1, 3, 0, 5, 8, 5),
        intArrayOf(2, 4, 6, 7, 9, 9),
        6
    )
}

fun maxMeetings(start: IntArray, end: IntArray, n: Int): Int {

    val meetingList = ArrayList<Meeting>()
    var maxMeeting = 0
    var lastMeetingEndTime = 0
    for (i in 0 until n) {
        meetingList.add(Meeting(start[i], end[i]))
    }
    Collections.sort(meetingList) { (_, end1), (_, end2) -> end1.compareTo(end2) }
    maxMeeting += 1
    lastMeetingEndTime = meetingList[0].end
    for (i in 1 until meetingList.size) {
        if (meetingList[i].start > lastMeetingEndTime) {
            lastMeetingEndTime = meetingList[i].end
            maxMeeting += 1
        }
    }
    return maxMeeting
}
