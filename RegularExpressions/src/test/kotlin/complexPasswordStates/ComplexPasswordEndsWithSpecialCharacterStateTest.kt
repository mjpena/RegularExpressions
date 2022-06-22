package complexPasswordStates

import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ComplexPasswordEndsWithSpecialCharacterStateTest{
    @Test
    fun isAcceptingFalse(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "klfjg@o8208Lfji)")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeSpecialCharacter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "ljgoiPwjg08u4!+")
        assert(patternDetector.state is ComplexPasswordEndsWithSpecialCharacterState)
    }

    @Test
    fun consumeNonSpecialCharacter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("complex password", "ljgoiPwjg08u4!i")
        assert(patternDetector.state is ComplexPasswordValidState)
    }
}