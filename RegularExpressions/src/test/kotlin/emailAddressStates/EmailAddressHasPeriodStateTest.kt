package emailAddressStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EmailAddressHasPeriodStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a@a.")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeSpace(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a@a. ")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumePeriod(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a@a..")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeAt(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a@a.@")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a@a.a")
        assertTrue(patternDetector.state is EmailAddressValidState)
    }
}