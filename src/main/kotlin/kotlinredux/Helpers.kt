package kotlinredux

fun <S, A> combineReducers(reducers: Map<String, Reducer<*, A>>): Reducer<S, A> = combineReducers(
    reducers.forEach { js("this[it.key] = it.value;") }.unsafeCast<ReducerContainer<S, A>>())

interface RAction