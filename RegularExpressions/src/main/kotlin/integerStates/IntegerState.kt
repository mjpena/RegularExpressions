package integerStates

import ConstantCharacters
import PatternDetector
import State

abstract class IntegerState(patternDetector: PatternDetector): State(patternDetector){
    protected val integers: String = ConstantCharacters.integers
    protected val nonZeroIntegers: String = ConstantCharacters.nonZeroIntegers
}