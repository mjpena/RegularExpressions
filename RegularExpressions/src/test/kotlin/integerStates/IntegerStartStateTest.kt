package integerStates

import InvalidState
import PatternDetector
import floatingPointStates.FloatingPointValidState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntegerStartStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeNonZeroInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "9")
        assertTrue(patternDetector.state is IntegerValidState)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "0")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "a")
        assertTrue(patternDetector.state is InvalidState)
    }
}