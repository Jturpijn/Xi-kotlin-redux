package reducers

import State
import kotlinredux.Action

fun clickReducer(state: State = State(), action: Action) =
    when(action.type) {
        "CLICKINCREMENT" -> State(state.clicker +1)
        "CLICKDECREMENT" -> State(state.clicker -1)
        else -> state
    }