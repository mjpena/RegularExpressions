import PatternDetector

abstract class State(val patternDetector: PatternDetector) {
    abstract val isAccepting: Boolean

    abstract fun consumeInput(character: String)
}