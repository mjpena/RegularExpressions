package emailAddressStates

import InvalidState
import PatternDetector
import complexPasswordStates.ComplexPasswordEndsWithSpecialCharacterState
import complexPasswordStates.ComplexPasswordValidState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EmailAddressStartStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeSpace(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", " ")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeAt(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "@")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("email address", "+")
        assertTrue(patternDetector.state is EmailAddressPartOneNotEmptyState)
    }
}