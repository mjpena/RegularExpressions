package complexPasswordStates

import PatternDetector

class ComplexPasswordHasCapitolLetterState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character !in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"){
            patternDetector.state = ComplexPasswordEndsWithSpecialCharacterState(patternDetector)
        }
    }
}