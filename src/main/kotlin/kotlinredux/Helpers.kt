package kotlinredux

import State

fun <S, A> combineReducers(reducers: Map<String, Reducer<*, A>>): Reducer<S, A> {
    val obj: dynamic = object{}
    reducers.forEach { obj[it.key] = it.value}
    return combineReducers(
        obj.unsafeCast<ReducerContainer<S, A>>()
    )
}

interface RAction