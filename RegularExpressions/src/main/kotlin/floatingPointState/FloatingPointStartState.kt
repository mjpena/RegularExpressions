package floatingPointState

import InvalidState
import PatternDetector
import integerState.IntegerValidState

class FloatingPointStartState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == "0"){
            patternDetector.state = FloatingPointStartsWithZeroState(patternDetector)
        }
        else if(character == "."){
            patternDetector.state = FloatingPointHasPeriodState(patternDetector)
        }
        else if (character in "123456789") {
            patternDetector.state = FloatingPointStartsWithNonZeroState(patternDetector)
        }
        else {
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}