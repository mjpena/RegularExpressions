import integerStates.IntegerValidState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PatternDetectorTest {
    @Test
    fun validBinaryNumber(){
        val patternDetector: PatternDetector = PatternDetector()
        assertTrue(patternDetector.detect("binary number", "1"))
        assertTrue(patternDetector.detect("binary number", "11"))
        assertTrue(patternDetector.detect("binary number", "101"))
        assertTrue(patternDetector.detect("binary number", "1001010001"))
        assertTrue(patternDetector.detect("binary number", "1111111"))
    }

    @Test
    fun invalidBinaryNumber(){
        val patternDetector: PatternDetector = PatternDetector()
        assertFalse(patternDetector.detect("binary number", ""))
        assertFalse(patternDetector.detect("binary number", "0"))
        assertFalse(patternDetector.detect("binary number", "01"))
        assertFalse(patternDetector.detect("binary number", "10"))
        assertFalse(patternDetector.detect("binary number", "101110"))
        assertFalse(patternDetector.detect("binary number", "1011141"))
        assertFalse(patternDetector.detect("binary number", "101a141"))
    }

    @Test
    fun validComplexPassword(){
        val patternDetector: PatternDetector = PatternDetector()
        assertTrue(patternDetector.detect("complex password", "k*Lj38*0"))
        assertTrue(patternDetector.detect("complex password", "LLLL(((((((P"))
        assertTrue(patternDetector.detect("complex password", "vk)L38()gkJFUH"))
    }

    @Test
    fun invalidComplexPassword(){
        val patternDetector: PatternDetector = PatternDetector()
        assertFalse(patternDetector.detect("complex password", ""))
        assertFalse(patternDetector.detect("complex password", "dk_Ljef"))
        assertFalse(patternDetector.detect("complex password", "djg)*ugkd*&&"))
        assertFalse(patternDetector.detect("complex password", "LHD83982Jljgo"))
        assertFalse(patternDetector.detect("complex password", "Djj807**jlgie)"))
    }

    @Test
    fun validEmailAddress(){
        val patternDetector: PatternDetector = PatternDetector()
        assertTrue(patternDetector.detect("email address", "a@b.c"))
        assertTrue(patternDetector.detect("email address", "test@gmail.com"))
        assertTrue(patternDetector.detect("email address", "{}*\$.&\$*(@*\$%&.*&*"))
    }

    @Test
    fun invalidEmailAddress(){
        val patternDetector: PatternDetector = PatternDetector()
        assertFalse(patternDetector.detect("email address", ""))
        assertFalse(patternDetector.detect("email address", "@b.c"))
        assertFalse(patternDetector.detect("email address", "a @b.c"))
        assertFalse(patternDetector.detect("email address", "a@b .c"))
        assertFalse(patternDetector.detect("email address", "a@b.dl.c"))
        assertFalse(patternDetector.detect("email address", "a@b@dl.c"))
        assertFalse(patternDetector.detect("email address", "a@.c"))
        assertFalse(patternDetector.detect("email address", "a@sf."))
    }

    @Test
    fun validFloatingPoint(){
        val patternDetector: PatternDetector = PatternDetector()
        assertTrue(patternDetector.detect("floating point", "0.0"))
        assertTrue(patternDetector.detect("floating point", "0.30"))
        assertTrue(patternDetector.detect("floating point", ".354"))
        assertTrue(patternDetector.detect("floating point", "1455.4980"))
    }

    @Test
    fun invalidFloatingPoint(){
        val patternDetector: PatternDetector = PatternDetector()
        assertFalse(patternDetector.detect("floating point", ""))
        assertFalse(patternDetector.detect("floating point", "09.3"))
        assertFalse(patternDetector.detect("floating point", "190"))
        assertFalse(patternDetector.detect("floating point", "190."))
        assertFalse(patternDetector.detect("floating point", "190.90v"))
        assertFalse(patternDetector.detect("floating point", "190.90.09"))
    }

    @Test
    fun validInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        assertTrue(patternDetector.detect("integer", "1"))
        assertTrue(patternDetector.detect("integer", "1048039"))
        assertTrue(patternDetector.detect("integer", "14808492"))
    }

    @Test
    fun invalidInteger(){
        val patternDetector: PatternDetector = PatternDetector()
        assertFalse(patternDetector.detect("integer", ""))
        assertFalse(patternDetector.detect("integer", "0244"))
        assertFalse(patternDetector.detect("integer", "2490?"))
        assertFalse(patternDetector.detect("integer", "249f0"))
    }
}