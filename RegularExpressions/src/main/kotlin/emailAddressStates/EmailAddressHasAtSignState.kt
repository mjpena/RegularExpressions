package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressHasAtSignState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == " " || character == "." || character == "@"){
            patternDetector.state = InvalidState(patternDetector)
        }
        else{
            patternDetector.state = EmailAddressPartTwoNotEmptyState(patternDetector)
        }
    }
}