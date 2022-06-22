package floatingPointStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FloatingPointValidStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "1.0")
        assertTrue(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "1.02")
        assertTrue(patternDetector.state is FloatingPointValidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "1.4a")
        assertTrue(patternDetector.state is InvalidState)
    }

    fun consumeOther2(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "1.2.")
        assertTrue(patternDetector.state is InvalidState)
    }
}