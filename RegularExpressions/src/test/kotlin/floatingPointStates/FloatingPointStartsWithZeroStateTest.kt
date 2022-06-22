package floatingPointStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FloatingPointStartsWithZeroStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "0")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumePeriod(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "0.")
        assertTrue(patternDetector.state is FloatingPointHasPeriodState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "09")
        assertTrue(patternDetector.state is InvalidState)
    }
}