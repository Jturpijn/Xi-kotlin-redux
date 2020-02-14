package reducers

import State
import kotlinredux.Action

fun clickReducer(state: Int = State().clicker, action: Action) =
    when(action.type) {
        "CLICKINCREMENT" -> state +1
        "CLICKDECREMENT" -> state -1
        else -> state
    }