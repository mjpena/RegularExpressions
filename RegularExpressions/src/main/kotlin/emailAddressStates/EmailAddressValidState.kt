package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressValidState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character == space || character == at || character == period){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}