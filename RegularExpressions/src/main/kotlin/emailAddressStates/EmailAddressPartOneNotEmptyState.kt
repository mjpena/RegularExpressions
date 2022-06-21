package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressPartOneNotEmptyState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == at){
            patternDetector.state = EmailAddressHasAtSignState(patternDetector)
        }
        else if (character == space){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}