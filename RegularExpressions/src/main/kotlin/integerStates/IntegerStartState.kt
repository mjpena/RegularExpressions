package integerStates

import InvalidState
import PatternDetector

class IntegerStartState(patternDetector: PatternDetector): IntegerState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in "123456789") {
            patternDetector.state = IntegerValidState(patternDetector)
        } else {
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}