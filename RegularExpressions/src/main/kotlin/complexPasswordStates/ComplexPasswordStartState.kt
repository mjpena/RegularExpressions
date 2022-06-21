package complexPasswordStates

import PatternDetector

class ComplexPasswordStartState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in capitolLetters){
            patternDetector.state = ComplexPasswordHasCapitolLetterState(patternDetector)
        }
        else if (character !in lowercaseLetters){
            patternDetector.state = ComplexPasswordHasSpecialCharacterState(patternDetector)
        }
    }
}