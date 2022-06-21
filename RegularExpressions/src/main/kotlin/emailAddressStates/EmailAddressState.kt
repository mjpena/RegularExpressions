package emailAddressStates

import ConstantCharacters
import PatternDetector
import State

abstract class EmailAddressState(patternDetector: PatternDetector): State(patternDetector){
    protected val at: String = ConstantCharacters.at
    protected val period: String = ConstantCharacters.period
    protected val space: String = ConstantCharacters.space
}