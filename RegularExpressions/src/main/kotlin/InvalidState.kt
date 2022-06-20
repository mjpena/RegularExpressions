class InvalidState(patternDetector: PatternDetector): State(patternDetector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        // noop
    }
}