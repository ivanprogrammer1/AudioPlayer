package com.tattoshaman.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

class CoroutineDispatchers(
    val Main: MainCoroutineDispatcher,
    val IO: CoroutineDispatcher
)