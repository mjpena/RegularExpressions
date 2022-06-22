package binaryNumberStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryNumberEndsWithOneStateTest{
    @Test
    fun isAcceptingTrue(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "1")
        assertTrue(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOne(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "11")
        assertTrue(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "10")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "1m")
        assertFalse(patternDetector.state.isAccepting)
    }
}