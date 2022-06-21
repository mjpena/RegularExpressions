package complexPasswordStates

import PatternDetector

class ComplexPasswordHasSpecialCharacterState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in capitolLetters){
            patternDetector.state = ComplexPasswordValidState(patternDetector)
        }
    }
}