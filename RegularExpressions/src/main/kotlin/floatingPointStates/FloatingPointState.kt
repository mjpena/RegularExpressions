package floatingPointStates

import ConstantCharacters
import PatternDetector
import State

abstract class FloatingPointState(patternDetector: PatternDetector): State(patternDetector){
    protected val integers: String = ConstantCharacters.integers
    protected val nonZeroIntegers: String = ConstantCharacters.nonZeroIntegers
    protected val period: String = ConstantCharacters.period
    protected val zero: String = ConstantCharacters.zero
}