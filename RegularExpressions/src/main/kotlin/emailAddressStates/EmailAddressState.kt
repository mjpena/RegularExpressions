package emailAddressStates

import PatternDetector
import State

abstract class EmailAddressState(patternDetector: PatternDetector): State(patternDetector)