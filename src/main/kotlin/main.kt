
import actions.clickDecrement
import actions.clickIncrement
import actions.countDecrement
import actions.countIncrement
import kotlinredux.Action
import kotlinredux.Middleware
import kotlinredux.applyMiddleware
import kotlinredux.createStore
import reducers.rootReducer

@JsModule("redux-logger")
external val middleware: dynamic
val logger = middleware.logger as Middleware<State, Action, Action, Action, Action>

data class State(
    val counter: Int = 0,
    val clicker: Int = 0
)

val store = createStore(rootReducer(), State(), applyMiddleware(logger))

fun main() {
    println("counter has value = " + store.getState().counter)
    println("clicker has value = " + store.getState().clicker)
    store.dispatch(countIncrement); store.dispatch(countIncrement)
    store.dispatch(clickIncrement); store.dispatch(clickIncrement)
    println("text" + store.getState()::class)
    println("counter now has value = " + store.getState().counter)
    println("clicker now has value = " + store.getState().clicker)
    println("Wat de hekkie : " + store.dispatch(countDecrement))
    store.dispatch(clickDecrement)
    println("counter now has value = " + store.getState().counter)
    println("clicker now has value = " + store.getState().clicker)
}