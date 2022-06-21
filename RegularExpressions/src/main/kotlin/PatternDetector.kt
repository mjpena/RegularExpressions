import binaryNumberStates.BinaryNumberStartState
import complexPasswordStates.ComplexPasswordStartState
import complexPasswordStates.ComplexPasswordState
import emailAddressStates.EmailAddressStartState
import floatingPointStates.FloatingPointStartState
import integerStates.IntegerStartState

class PatternDetector {
    lateinit var state: State

    private fun getPatternStartState(pattern: String): State {
        val patternStates: Map<String, State> = mapOf(
            Pair("integer", IntegerStartState(this)),
            Pair("floating point", FloatingPointStartState(this)),
            Pair("binary number", BinaryNumberStartState(this)),
            Pair("email address", EmailAddressStartState(this)),
            Pair("complex password", ComplexPasswordStartState(this)),
        )

        return patternStates[pattern] ?: throw Exception("$pattern is not a valid pattern.")
    }

    fun detect(pattern: String, input: String): Boolean {
        state = getPatternStartState(pattern)
        if (state is ComplexPasswordState){
            if (input.length < 8) return false
        }

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