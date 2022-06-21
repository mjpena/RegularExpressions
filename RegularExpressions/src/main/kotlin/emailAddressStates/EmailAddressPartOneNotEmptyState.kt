package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressPartOneNotEmptyState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == "@"){
            patternDetector.state = EmailAddressHasAtSignState(patternDetector)
        }
        else if (character == " "){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}