package binaryNumberStates

import InvalidState
import PatternDetector

class BinaryNumberEndsWithZeroState(patternDetector: PatternDetector): BinaryNumberState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character == one){
            patternDetector.state = BinaryNumberEndsWithOneState(patternDetector)
        }
        else if (character != zero){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}