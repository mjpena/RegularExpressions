import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PatternDetectorTest{
    private val patternDetector: PatternDetector = PatternDetector()

    @Test
    fun invalidPattern(){
        assertThrows<Exception>{
            patternDetector.detect("non pattern", "some string")
        }
    }

    @Test
    fun validInteger(){
        assertTrue(patternDetector.detect("integer", "1"))
        assertTrue(patternDetector.detect("integer", "123"))
        assertTrue(patternDetector.detect("integer", Int.MAX_VALUE.toString()))
    }

    @Test
    fun invalidInteger(){
        assertFalse(patternDetector.detect("integer", ""))
        assertFalse(patternDetector.detect("integer", "0123"))
        assertFalse(patternDetector.detect("integer", "123?"))
        assertFalse(patternDetector.detect("integer", "123a"))
        assertFalse(patternDetector.detect("integer", Int.MIN_VALUE.toString()))
    }

    @Test
    fun validFloatingPoint(){
        assertTrue(patternDetector.detect("floating point", "0.123"))
        assertTrue(patternDetector.detect("floating point", ".123"))
        assertTrue(patternDetector.detect("floating point", "123.123"))
    }

    @Test
    fun invalidFloatingPoint(){
        assertFalse(patternDetector.detect("floating point", "?902"))
        assertFalse(patternDetector.detect("floating point", "a902"))
    }
}