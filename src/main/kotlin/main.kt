import actions.countIncrement
import kotlinredux.*
import reducers.rootReducer

// Create Redux Saga middleware
@JsModule("redux-saga")
external val rsmiddleware: dynamic
// rsmiddleware.default() uses the function 'run' to build the actual middleware, I'll assume since the lack of errors.
val sagaMiddleware = rsmiddleware.default() as Middleware<State, Action, Action, Action, Action>

// Create Redux-logger middleware
@JsModule("redux-logger")
external val middleware: dynamic
val logger = middleware.logger as Middleware<State, Action, Action, Action, Action>

data class State(
    val counter: Int = 0,
    val clicker: Int = 0
)

// line +/- 256. xi_kotlin_redux.js | replace new State() to {} | createStore(rootReducer(), {}, applyMiddleware(logger)); prevents Object error
val store = createStore(rootReducer(), State(), applyMiddleware(logger, sagaMiddleware))

fun main() {
    println("counter has value = " + store.getState().counter)
    store.dispatch(countIncrement); store.dispatch(countIncrement)
    println("counter now has value = " + store.getState().counter)

    // sagaMiddleware.run() only takes a js generator functions as a parameter. find a way to write it in kotlin.
    // line 257, insert -> sagaMiddleware.run(function* helloworld() { console.log('hello saga world');}); <- works
    // sagaMiddleware.run(asyncIncrement()) <- Presumably doesn't work since asyncIncrement() isn't a generator function
    println("counter final value = " + store.getState().counter)
}