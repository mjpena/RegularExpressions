package emailAddressStates

import InvalidState
import PatternDetector

class EmailAddressPartTwoNotEmptyState(patternDetector: PatternDetector): EmailAddressState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == period){
            patternDetector.state = EmailAddressHasPeriodState(patternDetector)
        }
        else if (character == space || character == at){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}