package com.problemsolving.leetcode

fun main() {
    println(canCompleteCircuit(intArrayOf(3,3,4), intArrayOf(3,4,4)))
}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var totalTripCost = 0
    var startStationIdx = -1
    for (i in 0 until gas.size) {
        val singleTripCost = gas[i] - cost[i]
        if (singleTripCost < 0)
            continue
        totalTripCost += singleTripCost
        var stationIdx = if(i == gas.size-1) 0 else i + 1
        var loopCounter = 0

        while (loopCounter < gas.size - 1) {
            totalTripCost += gas[stationIdx % gas.size] - cost[stationIdx % gas.size]
            if (totalTripCost < 0) {
                totalTripCost = 0
                startStationIdx = -1
                break
            }
            loopCounter++
            stationIdx++
        }
        if (loopCounter == gas.size - 1) {
            startStationIdx = i
            break
        }

    }
    return startStationIdx
}


