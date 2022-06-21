package floatingPointStates

import InvalidState
import PatternDetector

class FloatingPointValidState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character !in integers){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}