package binaryNumberStates

import InvalidState
import PatternDetector

class BinaryNumberStartState(patternDetector: PatternDetector): BinaryNumberState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == one){
            patternDetector.state = BinaryNumberEndsWithOneState(patternDetector)
        }
        else{
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}