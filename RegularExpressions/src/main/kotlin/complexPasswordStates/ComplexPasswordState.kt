package complexPasswordStates

import ConstantCharacters
import PatternDetector
import State

abstract class ComplexPasswordState(patternDetector: PatternDetector): State(patternDetector){
    protected val lowercaseLetters: String = ConstantCharacters.lowercaseLetters
    protected val capitolLetters: String = ConstantCharacters.capitolLetters
    protected val nonSpecialCharacters: String = ConstantCharacters.lowercaseLetters + ConstantCharacters.capitolLetters + ConstantCharacters.integers
}