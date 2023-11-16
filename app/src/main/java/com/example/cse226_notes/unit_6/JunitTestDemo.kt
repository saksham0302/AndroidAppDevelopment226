package com.example.cse226_notes.unit_6

import junit.framework.TestCase.*
import org.junit.Test

class JunitTestDemo {

    private val testSample: JunitSample = JunitSample()

    @Test
    fun testSum() {

        val expected = 42
        assertEquals(expected, testSample.sum(40, 2))
    }

    @Test
    fun testBool() {

        val expected = false
        assertFalse(expected)
        assertTrue(expected)
    }
}