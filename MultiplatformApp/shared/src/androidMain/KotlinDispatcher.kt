package com.subhipandey

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CouroutineContext

internal actual val ApplicationDispatcher: CoroutineContext = Dispatcher.IO
