import integerState.IntegerStartState

class PatternDetector {
    lateinit var state: State

    private fun getPatternStartState(pattern: String): State {
        val patternStates: Map<String, State> = mapOf(
            Pair("integer", IntegerStartState(this))
        )

        return patternStates[pattern] ?: throw Exception("$pattern is not a valid pattern.")
    }

    fun detect(pattern: String, input: String): Boolean {
        state = getPatternStartState(pattern)
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (character in characters) {
            state.consumeInput(character)
        }

        return state.isAccepting
    }
}