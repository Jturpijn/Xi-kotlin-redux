package kotlinreduxsaga
// These types are taken from the Redux-Saga
// build/js/node_modules/@redux-saga/core/types/index.d.ts
// That is also where the 'createSagaMiddleware' function is located, which is used to create the middleware...

external interface Buffer {
    fun isEmpty(): Boolean
    fun put()
    fun take()
    fun flush(): Array<Any>
}

external interface Channel {
    fun take()
    fun push()
    fun flush()
    fun close()
}

external interface Task {
    fun isRunning(): Boolean
    fun isCancelled(): Boolean
    fun cancel()
}
