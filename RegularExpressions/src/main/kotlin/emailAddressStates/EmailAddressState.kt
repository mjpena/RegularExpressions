package emailAddressStates

import PatternDetector
import State

abstract class EmailAddressState(patternDetector: PatternDetector): State(patternDetector){
    protected val at: String = "@"
    protected val period: String = "."
    protected val space: String = " "
}