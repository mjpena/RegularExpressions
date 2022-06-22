package floatingPointStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FloatingPointStartsWithNonZeroStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "1")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "409")
        assertTrue(patternDetector.state is FloatingPointStartsWithNonZeroState)
    }

    @Test
    fun consumePeriod(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "1.")
        assertTrue(patternDetector.state is FloatingPointHasPeriodState)
    }


    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "p")
        assertTrue(patternDetector.state is InvalidState)
    }
}