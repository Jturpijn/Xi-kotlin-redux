import kotlinredux.createStore
import reducers.rootReducer
import kotlin.test.*

class AppTest {
    @Test
    fun testCreateStore() {
        createStore(rootReducer(), State())
    }
}
