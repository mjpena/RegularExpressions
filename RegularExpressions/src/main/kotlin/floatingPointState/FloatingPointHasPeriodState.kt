package floatingPointState

import InvalidState
import PatternDetector

class FloatingPointHasPeriodState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in "0123456789"){
            patternDetector.state = FloatingPointValidState(patternDetector)
        }
        else {
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}