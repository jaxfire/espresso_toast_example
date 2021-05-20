package com.example.testinglearning

import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import java.lang.NumberFormatException

class Dependency1(val value1: Int)
class Dependency2(val value2: String)

class SystemUnderTest(
        private val dependency1: Dependency1,
        private val dependency2: Dependency2
) {
    fun calculate(): Int {
        return try {
            dependency1.value1 + dependency2.value2.toInt()
        } catch (e: NumberFormatException) {
            -999
        }
    }
}

class MyUnitTest {
    @Test
    fun calculateAddsValues() {
        val doc1 = mockk<Dependency1>()
        val doc2 = mockk<Dependency2>()

        every { doc1.value1 } returns 5
        every { doc2.value2 } returns "6"

        val sut = SystemUnderTest(doc1, doc2)

        assertEquals(11, sut.calculate())
    }

    @Test
    fun numberFormatExceptionIsHandled() {
        val doc1 = mockk<Dependency1>()
        val doc2 = mockk<Dependency2>()

        every { doc1.value1 } returns 5
        every { doc2.value2 } returns "a"

        val sut = SystemUnderTest(doc1, doc2)

        assertEquals(-999, sut.calculate())
    }
}