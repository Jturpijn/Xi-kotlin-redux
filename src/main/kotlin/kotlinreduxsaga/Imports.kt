@file:JsModule("redux-saga")
package kotlinreduxsaga

import kotlinredux.Action

// These imports are taken from the redux-saga API reference
// https://redux-saga.js.org/docs/api/

external fun take(pattern: String)

external fun takeEvery(pattern: String, saga: ()-> Unit)

external fun put(action: Action)

external fun fork(fn: ()->Unit, args: Array<Any>)


