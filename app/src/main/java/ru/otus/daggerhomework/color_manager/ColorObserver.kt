package ru.otus.daggerhomework.color_manager

import kotlinx.coroutines.flow.StateFlow

interface ColorObserver {
    fun getObservable(): StateFlow<Int>
}