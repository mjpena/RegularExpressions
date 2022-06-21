package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressHasPeriodState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == " " || character == "@" || character == "."){
            patternDetector.state = InvalidState(patternDetector)
        }
        else{
            patternDetector.state = EmailAddressValidState(patternDetector)
        }
    }
}