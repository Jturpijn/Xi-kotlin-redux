package reducers

import State
import kotlinredux.Action

fun countReducer(state: Int = State().counter, action: Action) =
    when(action.type) {
        "COUNTINCREMENT" -> state +1
        "COUNTDECREMENT" -> state -1
        else -> state
    }