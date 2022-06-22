package complexPasswordStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ComplexPasswordHasSpecialCharacterStateTest{
    @Test
    fun isAcceptingFalse(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "klfjg@o8208")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeCapitolLetter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "ljgoiwjg08u4!P")
        assert(patternDetector.state is ComplexPasswordValidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "ljgoiwjg08u4!i")
        assert(patternDetector.state is ComplexPasswordHasSpecialCharacterState)
    }
}