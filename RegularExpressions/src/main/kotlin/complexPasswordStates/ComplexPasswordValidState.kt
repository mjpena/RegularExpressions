package complexPasswordStates

import PatternDetector

class ComplexPasswordValidState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character !in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"){
            patternDetector.state = ComplexPasswordEndsWithSpecialCharacterState(patternDetector)
        }
    }
}