package complexPasswordStates

import PatternDetector
import State

abstract class ComplexPasswordState(patternDetector: PatternDetector): State(patternDetector){
    protected val lowercaseLetters: String = "abcdefghijklmnopqrstuvwxyz"
    protected val capitolLetters: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
}