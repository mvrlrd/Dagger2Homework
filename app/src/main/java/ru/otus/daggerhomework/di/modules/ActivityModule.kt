package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.color_manager.ColorEmitter
import ru.otus.daggerhomework.color_manager.ColorObserver
import ru.otus.daggerhomework.color_manager.MyObserver

@Module
interface ActivityModule {

    @Binds
    fun bindColorObserver(myObserver: MyObserver): ColorObserver

    @Binds
    fun bindColorEmitter(myObserver: MyObserver): ColorEmitter
}