package complexPasswordStates

import PatternDetector

class ComplexPasswordHasCapitolLetterState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character !in nonSpecialCharacters){
            patternDetector.state = ComplexPasswordEndsWithSpecialCharacterState(patternDetector)
        }
    }
}