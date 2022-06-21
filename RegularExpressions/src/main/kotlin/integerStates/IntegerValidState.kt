package integerStates

import InvalidState
import PatternDetector

class IntegerValidState(patternDetector: PatternDetector): IntegerState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character !in integers) {
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}