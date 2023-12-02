package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.FragmentScope

@FragmentScope
@Component(dependencies = [ActivityComponent::class])
interface ReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
}