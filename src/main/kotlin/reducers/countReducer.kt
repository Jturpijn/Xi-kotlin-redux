package reducers

import State
import kotlinredux.Action

fun countReducer(state: State = State(), action: Action) =
    when(action.type) {
        "COUNTINCREMENT" -> State(state.counter +1)
        "COUNTDECREMENT" -> State(state.counter -1)
        else -> state
    }