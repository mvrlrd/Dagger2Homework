package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.ApplicationComponent
import ru.otus.daggerhomework.di.components.DaggerApplicationComponent

class App :Application() {
    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    fun getApplicationComponent() : ApplicationComponent{
        return component
    }
}