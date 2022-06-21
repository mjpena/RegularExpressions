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
        assertFalse(patternDetector.detect("floating point", ""))
        assertFalse(patternDetector.detect("floating point", "9"))
        assertFalse(patternDetector.detect("floating point", "0"))
        assertFalse(patternDetector.detect("floating point", "90."))
        assertFalse(patternDetector.detect("floating point", "90.!"))
        assertFalse(patternDetector.detect("floating point", "?902"))
        assertFalse(patternDetector.detect("floating point", "9a02"))
        assertFalse(patternDetector.detect("floating point", "90.2-"))
        assertFalse(patternDetector.detect("floating point", "0-"))
    }

    @Test
    fun validBinaryNumber(){
        assertTrue(patternDetector.detect("binary number", "1"))
        assertTrue(patternDetector.detect("binary number", "11"))
        assertTrue(patternDetector.detect("binary number", "101"))
        assertTrue(patternDetector.detect("binary number", "1001"))
    }

    @Test
    fun invalidBinaryNumber(){
        assertFalse(patternDetector.detect("binary number", ""))
        assertFalse(patternDetector.detect("binary number", "0"))
        assertFalse(patternDetector.detect("binary number", "10"))
        assertFalse(patternDetector.detect("binary number", "12"))
        assertFalse(patternDetector.detect("binary number", "104"))
        assertFalse(patternDetector.detect("binary number", "00"))
    }

    @Test
    fun validEmailAddress(){
        assertTrue(patternDetector.detect("email address", "a@b.c"))
        assertTrue(patternDetector.detect("email address", "joseph.ditton@usu.edu"))
        assertTrue(patternDetector.detect("email address", "{}*\$.&\$*(@*\$%&.*&*"))
    }

    @Test
    fun invalidEmailAddress(){
        assertFalse(patternDetector.detect("email address", ""))
        assertFalse(patternDetector.detect("email address", "@b.c"))
        assertFalse(patternDetector.detect("email address", "qdg@"))
        assertFalse(patternDetector.detect("email address", "qdg@@"))
        assertFalse(patternDetector.detect("email address", "qdg@geo."))
        assertFalse(patternDetector.detect("email address", "qdg"))
        assertFalse(patternDetector.detect("email address", "qdg@gioj"))
        assertFalse(patternDetector.detect("email address", "a@b@c.com"))
        assertFalse(patternDetector.detect("email address", "a.b@b.b.c"))
        assertFalse(patternDetector.detect("email address", "a.b@b. "))
        assertFalse(patternDetector.detect("email address", "a.b@b.."))
        assertFalse(patternDetector.detect("email address", "a.b@b.@"))
        assertFalse(patternDetector.detect("email address", "joseph ditton@usu.edu"))
    }

    @Test
    fun validComplexPassword(){
        assertTrue(patternDetector.detect("complex password", "akklf?ejgiojL!p"))
        assertTrue(patternDetector.detect("complex password", "!j9f0Leioijggjkd"))
        assertTrue(patternDetector.detect("complex password", "PLei90!j"))
        assertTrue(patternDetector.detect("complex password", "T4*f9fwjg2Lo"))
        assertTrue(patternDetector.detect("complex password", "T-Leiwgj92hwg!+=4"))
    }

    @Test
    fun invalidComplexPassword(){
        assertFalse(patternDetector.detect("complex password", "g$0L"))
        assertFalse(patternDetector.detect("complex password", "kdgjao92!#*dg84"))
        assertFalse(patternDetector.detect("complex password", "Lig902Jiogwjlgioj"))
        assertFalse(patternDetector.detect("complex password", "dlkjg289g2hgij45r"))
        assertFalse(patternDetector.detect("complex password", "dlkjg289*L2hgij45r!"))
    }
}