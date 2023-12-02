package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.color_manager.ColorEmitter
import ru.otus.daggerhomework.color_manager.ColorObserver
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.modules.ActivityModule
import javax.inject.Named

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun provideAppContext(): Context

    @Named("mainActivityContext")
    fun provideActivityContext(): Context

    fun provideColorEmitter(): ColorEmitter
    fun provideColorObserver(): ColorObserver

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @Named("mainActivityContext") activityContext: Context
        ): ActivityComponent
    }

    companion object {
        fun getActivityComponent(
            applicationComponent: ApplicationComponent,
            context: Context
        ): ActivityComponent {
            return DaggerActivityComponent.factory().create(applicationComponent, context)
        }
    }
}