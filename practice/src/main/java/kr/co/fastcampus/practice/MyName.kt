package kr.co.fastcampus.practice

import java.util.UUID

/**
 * @author soohwan.ok
 */
class MyName {

    private val uuid = UUID.randomUUID()

    override fun toString(): String {
        return uuid.toString()
    }
}