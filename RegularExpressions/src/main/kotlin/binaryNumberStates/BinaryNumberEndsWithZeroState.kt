package binaryNumberStates

import InvalidState
import PatternDetector

class BinaryNumberEndsWithZeroState(patternDetector: PatternDetector): BinaryNumberState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == "1"){
            patternDetector.state = BinaryNumberEndsWithOneState(patternDetector)
        }
        else if (character != "0"){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}