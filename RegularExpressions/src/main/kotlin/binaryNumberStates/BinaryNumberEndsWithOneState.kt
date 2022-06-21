package binaryNumberStates

import InvalidState
import PatternDetector

class BinaryNumberEndsWithOneState(patternDetector: PatternDetector): BinaryNumberState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character == zero){
            patternDetector.state = BinaryNumberEndsWithZeroState(patternDetector)
        }
        else if (character != one){
            patternDetector.state = InvalidState(patternDetector)
        }
    }
}