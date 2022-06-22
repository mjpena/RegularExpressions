package floatingPointStates

import InvalidState
import PatternDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FloatingPointHasPeriodStateTest {
    @Test
    fun isAccepting(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", ".")
        assertFalse(patternDetector.state.isAccepting)
    }

    @Test
    fun consumeInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", ".0")
        assertTrue(patternDetector.state is FloatingPointValidState)
    }

    @Test
    fun consumeOther(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", ".a")
        assertTrue(patternDetector.state is InvalidState)
    }

    fun consumeOther2(){
        val patternDetector: PatternDetector = PatternDetector()
        patternDetector.detect("floating point", "..")
        assertTrue(patternDetector.state is InvalidState)
    }
}