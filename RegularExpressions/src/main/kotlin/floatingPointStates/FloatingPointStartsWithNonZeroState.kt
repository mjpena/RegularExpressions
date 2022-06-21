package floatingPointStates

import InvalidState
import PatternDetector

class FloatingPointStartsWithNonZeroState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if(character == period){
            patternDetector.state = FloatingPointHasPeriodState(patternDetector)
        }
        else if (character !in integers){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}