package floatingPointStates

import PatternDetector
import State

abstract class FloatingPointState(patternDetector: PatternDetector): State(patternDetector){
    protected val integers: String = "0123456789"
    protected val nonZeroIntegers: String = "123456789"
    protected val period: String = "."
    protected val zero: String = "0"
}