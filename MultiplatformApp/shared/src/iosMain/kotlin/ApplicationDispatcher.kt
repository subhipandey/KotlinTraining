package com.subhipandey

import platform.darwin.dispatch_queue_t

internal class NoQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
): CouroutineDispatcher() {

}