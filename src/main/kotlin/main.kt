
import actions.clickDecrement
import actions.clickIncrement
import actions.countDecrement
import actions.countIncrement
import kotlinredux.createStore
import reducers.rootReducer

data class State(
    val counter: Int = 0,
    val clicker: Int = 0
)


val store = createStore(rootReducer(), State())

fun main() {
    println("counter has value = " + store.getState().counter)
    println("clicker has value = " + store.getState().clicker)
    store.dispatch(countIncrement); store.dispatch(countIncrement)
    store.dispatch(clickIncrement); store.dispatch(clickIncrement)
    println("counter now has value = " + store.getState().counter)
    println("clicker now has value = " + store.getState().clicker)
    store.dispatch(countDecrement)
    store.dispatch(clickDecrement)
    println("counter now has value = " + store.getState().counter)
    println("clicker now has value = " + store.getState().clicker)
}