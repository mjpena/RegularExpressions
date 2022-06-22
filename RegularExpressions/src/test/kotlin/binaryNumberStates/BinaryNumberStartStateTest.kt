package binaryNumberStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryNumberStartStateTest{

    @Test
    fun isAcceptingFalse(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOne(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "1")
        assertTrue(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "0")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("binary number", "m")
        assertFalse(patternDetector.state.isAccepting)
    }
}