package integerStates

import PatternDetector
import State

abstract class IntegerState(patternDetector: PatternDetector): State(patternDetector){
    protected val integers: String = "0123456789"
    protected val nonZeroIntegers: String = "123456789"
}