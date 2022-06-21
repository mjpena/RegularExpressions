package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressPartTwoNotEmptyState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == "."){
            patternDetector.state = EmailAddressHasPeriodState(patternDetector)
        }
        else if (character == " " || character == "@"){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}