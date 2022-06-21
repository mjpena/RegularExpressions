package complexPasswordStates

import PatternDetector

class ComplexPasswordEndsWithSpecialCharacterState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in nonSpecialCharacters){
            patternDetector.state = ComplexPasswordValidState(patternDetector)
        }
    }
}