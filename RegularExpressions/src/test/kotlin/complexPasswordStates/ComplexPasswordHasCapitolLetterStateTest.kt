package complexPasswordStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ComplexPasswordHasCapitolLetterStateTest{
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeSpecialCharacter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "jgdijg08P!")
        assert(patternDetector.state is ComplexPasswordEndsWithSpecialCharacterState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "kjpoef03kRjgijg")
        assertTrue(patternDetector.state is ComplexPasswordHasCapitolLetterState)
    }
}