package emailAddressStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EmailAddressPartOneNotEmptyStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeSpace(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "u ")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeAt(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a@")
        assertTrue(patternDetector.state is EmailAddressHasAtSignState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "a0")
        assertTrue(patternDetector.state is EmailAddressPartOneNotEmptyState)
    }
}