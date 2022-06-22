package floatingPointStates

import InvalidState
import PatternDetector
import emailAddressStates.EmailAddressPartTwoNotEmptyState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FloatingPointStartStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeZero(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "0")
        assertTrue(patternDetector.state is FloatingPointStartsWithZeroState)
    }

    @Test
    fun consumeNonZeroInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "4")
        assertTrue(patternDetector.state is FloatingPointStartsWithNonZeroState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "p")
        assertTrue(patternDetector.state is InvalidState)
    }
}