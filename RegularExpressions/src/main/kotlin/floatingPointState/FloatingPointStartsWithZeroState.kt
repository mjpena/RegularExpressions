package floatingPointState

import InvalidState
import PatternDetector

class FloatingPointStartsWithZeroState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == "."){
            patternDetector.state = FloatingPointHasPeriodState(patternDetector)
        }
        else{
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}