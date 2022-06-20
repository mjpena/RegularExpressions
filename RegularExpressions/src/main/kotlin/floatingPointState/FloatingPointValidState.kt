package floatingPointState

import InvalidState
import PatternDetector

class FloatingPointValidState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character !in "0123456789"){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}