import integerStates.IntegerValidState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InvalidStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "a")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "3ak9")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeSpecialCharacter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "3f!")
        assertTrue(patternDetector.state is InvalidState)
    }

    @Test
    fun consumeLetter(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("integer", "4?a")
        assertTrue(patternDetector.state is InvalidState)
    }
}