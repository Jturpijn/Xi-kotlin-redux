package sagas

import actions.countDecrement
import kotlinredux.Action
import kotlinreduxsaga.put

// This is a testing function. Using put() throws an error that put isn't a function
// Presumably because put() isn't a generator function.

fun asyncIncrement() {
    println("About to async")
    put(countDecrement as Action)
}