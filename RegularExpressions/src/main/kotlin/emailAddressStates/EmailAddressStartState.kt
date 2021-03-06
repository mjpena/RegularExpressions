package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressStartState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == space || character == at){
            patternDetector.state = InvalidState(patternDetector)
        }
        else{
            patternDetector.state = EmailAddressPartOneNotEmptyState(patternDetector)
        }
    }
}