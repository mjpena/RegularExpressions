package binaryNumberStates

import PatternDetector
import State

abstract class BinaryNumberState(patternDetector: PatternDetector): State(patternDetector){
    protected val zero: String = "0"
    protected val one: String = "1"
}