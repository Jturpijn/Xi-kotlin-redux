package actions

import kotlinredux.RAction
    inline fun action(type: String, other: dynamic.() -> Unit = {}): dynamic {
        val obj = js("{}")
        obj["type"] = type
        other(obj)
        return obj
    }

val clickIncrement = action("CLICKINCREMENT")
val clickDecrement = action("CLICKDECREMENT")
val countIncrement = action("COUNTINCREMENT")
val countDecrement = action("COUNTDECREMENT")

//class Increment: RAction
//class Decrement: RAction