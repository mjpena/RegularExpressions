import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PatternDetectorTest{
    @Test
    fun invalidPattern(){
        val patternDetector: PatternDetector = PatternDetector()
        assertThrows<Exception>{
            patternDetector.detect("non pattern", "some string")
        }
    }

    @Test
    fun validInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        assertTrue(patternDetector.detect("integer", "1"))
        assertTrue(patternDetector.detect("integer", "123"))
        assertTrue(patternDetector.detect("integer", Int.MAX_VALUE.toString()))
    }

    @Test
    fun invalidInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        assertFalse(patternDetector.detect("integer", ""))
        assertFalse(patternDetector.detect("integer", "0123"))
        assertFalse(patternDetector.detect("integer", "123?"))
        assertFalse(patternDetector.detect("integer", "123a"))
        assertFalse(patternDetector.detect("integer", Int.MIN_VALUE.toString()))
    }
}