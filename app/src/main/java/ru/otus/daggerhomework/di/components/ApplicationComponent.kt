package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.ApplicationScope
import javax.inject.Named

@ApplicationScope
@Component
interface ApplicationComponent {
    @Named("applicationContext")
    fun provideAppContext(): Context
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("applicationContext") applicationContext: Context): ApplicationComponent
    }
}