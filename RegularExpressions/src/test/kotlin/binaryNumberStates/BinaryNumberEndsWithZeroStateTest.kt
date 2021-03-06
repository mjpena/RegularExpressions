package binaryNumberStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryNumberEndsWithZeroStateTest{
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "10")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOne(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "101")
        assertTrue(patternDetector.state is BinaryNumberEndsWithOneState)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "100")
        assertTrue(patternDetector.state is BinaryNumberEndsWithZeroState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "10m")
        assertTrue(patternDetector.state is InvalidState)
    }
}