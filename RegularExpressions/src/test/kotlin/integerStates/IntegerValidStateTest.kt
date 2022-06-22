package integerStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntegerValidStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "3")
        assertTrue(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeNonZeroInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "93")
        assertTrue(patternDetector.state is IntegerValidState)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "80")
        assertTrue(patternDetector.state is IntegerValidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "4a")
        assertTrue(patternDetector.state is InvalidState)
    }
}