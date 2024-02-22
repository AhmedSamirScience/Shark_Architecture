package com.ascoding.shark_architecture.common.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun stop()
    abstract fun start()
}