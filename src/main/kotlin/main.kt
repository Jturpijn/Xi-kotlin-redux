
import actions.clickIncrement
import actions.countIncrement
import kotlinredux.createStore
import reducers.countReducer
import reducers.rootReducer

data class State(
    val counter: Int = 0,
    val clicker: Int = 0
)


val store = createStore(rootReducer(), State())

fun main() {
    println("counter has value = " + store.getState().counter)
    println("clicker has value = " + store.getState().clicker)
    store.dispatch(countIncrement)
    store.dispatch(clickIncrement)
    println("counter now has value = " + store.getState().counter)
    println("clicker now has value = " + store.getState().clicker)
}