package complexPasswordStates

import PatternDetector

class ComplexPasswordStartState(patternDetector: PatternDetector): ComplexPasswordState(patternDetector) {
    override val isAccepting: Boolean = false

    override fun consumeInput(character: String) {
        if (character in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"){
            patternDetector.state = ComplexPasswordHasCapitolLetterState(patternDetector)
        }
        else if (character !in "abcdefghijklmnopqrstuvwxyz"){
            patternDetector.state = ComplexPasswordHasSpecialCharacterState(patternDetector)
        }
    }
}