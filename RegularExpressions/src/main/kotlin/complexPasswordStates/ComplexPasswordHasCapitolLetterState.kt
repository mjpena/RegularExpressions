package complexPasswordStates

import PatternDetector

class ComplexPasswordHasCapitolLetterState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character !in lowercaseLetters && character !in capitolLetters){
            patternDetector.state = ComplexPasswordEndsWithSpecialCharacterState(patternDetector)
        }
    }
}