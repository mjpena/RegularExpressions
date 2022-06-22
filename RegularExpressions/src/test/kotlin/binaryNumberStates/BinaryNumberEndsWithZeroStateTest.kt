package binaryNumberStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryNumberEndsWithZeroStateTest{
    @Test
    fun isAcceptingFalse(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "10")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOne(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "101")
        assertTrue(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "100")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "10m")
        assertFalse(patternDetector.state.isAccepting)
    }
}