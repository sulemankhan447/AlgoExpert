package com.problemsolving.leetcode

class LRUCache(capacity: Int) {
    private val map = HashMap<Int, Node>()

    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)
    private var len: Int

    init {
        head.next = tail
        tail.prev = head
        this.len = capacity
    }


    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            val node = map.get(key)
            removeNode(node)
            insertNode(node)
            return node?.value ?: 0
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            removeNode(map.get(key))
        }
        if (map.size == len) {
            removeNode(tail.prev)
        }
        insertNode(Node(key, value))

    }

    fun insertNode(node: Node?) {
        node?.run {
            val oldHeadNext = head.next
            head.next = node
            node.prev = head
            oldHeadNext?.prev = node
            node.next = oldHeadNext
            map.put(node.key, node)
        }

    }

    fun removeNode(node: Node?) {
        map.remove(node?.key)
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }


    class Node(
        val key: Int, var value: Int, var prev: Node? = null, var next: Node? = null
    )
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */