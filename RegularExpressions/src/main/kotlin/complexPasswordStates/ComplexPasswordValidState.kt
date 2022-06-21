package complexPasswordStates

import PatternDetector

class ComplexPasswordValidState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = true

    override fun consumeInput(character: String) {
        if (character !in lowercaseLetters && character !in capitolLetters){
            patternDetector.state = ComplexPasswordEndsWithSpecialCharacterState(patternDetector)
        }
    }
}