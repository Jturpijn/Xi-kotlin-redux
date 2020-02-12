package reducers

import State
import kotlinredux.Reducer
import kotlin.reflect.KProperty1

fun <S, A, R> combineReducers(reducers: Map<KProperty1<S, R>, Reducer<*, A>>): Reducer<S, A> {
    return kotlinredux.combineReducers(reducers.mapKeys { it.key.name })
}

fun rootReducer() = combineReducers(
    mapOf(
        State::counter to ::countReducer,
        State::clicker to ::clickReducer
    )
)