package binaryNumberStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryNumberStartStateTest{

    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOne(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "1")
        assertTrue(patternDetector.state is BinaryNumberEndsWithOneState)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "0")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeZero2(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "10")
        assertTrue(patternDetector.state is BinaryNumberEndsWithZeroState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "m")
        assertTrue(patternDetector.state is InvalidState)
    }
}