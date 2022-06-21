package complexPasswordStates

import PatternDetector

class ComplexPasswordHasSpecialCharacterState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"){
            patternDetector.state = ComplexPasswordValidState(patternDetector)
        }
    }
}