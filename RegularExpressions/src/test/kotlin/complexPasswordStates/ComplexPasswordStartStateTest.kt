package complexPasswordStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ComplexPasswordStartStateTest{
    @Test
    fun isAcceptingFalse(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeSpecialCharacter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "ljgoiwjg08u4!")
        assert(patternDetector.state is ComplexPasswordHasSpecialCharacterState)
    }

    @Test
    fun consumeCapitolLetter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "wjgoiwejg338r9P")
        assertTrue(patternDetector.state is ComplexPasswordHasCapitolLetterState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "kjpoef03kl")
        assertTrue(patternDetector.state is ComplexPasswordStartState)
    }
}