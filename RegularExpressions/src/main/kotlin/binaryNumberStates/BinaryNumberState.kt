package binaryNumberStates

import ConstantCharacters
import PatternDetector
import State

abstract class BinaryNumberState(patternDetector: PatternDetector): State(patternDetector){
    protected val zero: String = ConstantCharacters.zero
    protected val one: String = ConstantCharacters.one
}