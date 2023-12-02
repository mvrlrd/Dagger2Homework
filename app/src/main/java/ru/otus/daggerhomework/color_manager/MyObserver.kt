package ru.otus.daggerhomework.color_manager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject


@ActivityScope
class MyObserver @Inject constructor(): ColorEmitter, ColorObserver {
    private val stateFlow = MutableStateFlow<Int>(INITIAL_COLOR)

    override fun emitColor(color: Int) {
        stateFlow.value = color
    }
    override fun getObservable(): StateFlow<Int> {
        return stateFlow.asStateFlow()
    }

    companion object{
        private const val INITIAL_COLOR = 0
    }
}