package binaryNumberStates

import InvalidState
import PatternDetector

class BinaryNumberEndsWithOneState(patternDetector: PatternDetector): BinaryNumberState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character == "0"){
            patternDetector.state = BinaryNumberEndsWithZeroState(patternDetector)
        }
        else if (character != "1"){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}