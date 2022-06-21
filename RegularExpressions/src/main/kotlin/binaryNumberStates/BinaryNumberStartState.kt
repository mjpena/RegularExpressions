package binaryNumberStates

import InvalidState
import PatternDetector

class BinaryNumberStartState(patternDetector: PatternDetector): BinaryNumberState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == "1"){
            patternDetector.state = BinaryNumberEndsWithOneState(patternDetector)
        }
        else{
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}