package com.subhipandey

import io.ktor.http.ContentType
import kotlin.coroutines.CoroutineContext

expect fun platformName(): String


    class Greeting {
        fun greeting(): String = "Hello, ${platformName()}"
    }

internal expect val ApplicationDispatcher: CoroutineContext