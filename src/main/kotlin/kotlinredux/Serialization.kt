@file:Suppress("unused")
package kotlinredux

import kotlinx.serialization.*
import kotlinx.serialization.internal.*
import kotlinx.serialization.json.*

@ImplicitReflectionSerializer
inline fun <reified A : RAction> serializeAction(action: A): String {
    return "{\"type\":\"${A::class.simpleName}\",${Json.stringify(action).drop(1)}"
}

@UnstableDefault
@ImplicitReflectionSerializer
inline fun <reified A : RAction> deserializeAction(action: String): A? {
    val map = Json.parse((StringSerializer to StringSerializer).map, action)
    return if (map["type"] == A::class.simpleName) Json.nonstrict.parse(action) else null
}