package floatingPointStates

import InvalidState
import PatternDetector

class FloatingPointStartsWithNonZeroState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if(character == "."){
            patternDetector.state = FloatingPointHasPeriodState(patternDetector)
        }
        else if (character !in "0123456789"){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}