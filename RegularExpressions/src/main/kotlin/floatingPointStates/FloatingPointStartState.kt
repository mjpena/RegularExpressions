package floatingPointStates

import InvalidState
import PatternDetector

class FloatingPointStartState(patternDetector: PatternDetector): FloatingPointState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == zero){
            patternDetector.state = FloatingPointStartsWithZeroState(patternDetector)
        }
        else if(character == period){
            patternDetector.state = FloatingPointHasPeriodState(patternDetector)
        }
        else if (character in nonZeroIntegers) {
            patternDetector.state = FloatingPointStartsWithNonZeroState(patternDetector)
        }
        else {
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}