package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.di.modules.ProducerModule

@FragmentScope
@Component(
    modules = [ProducerModule::class],
    dependencies = [ActivityComponent::class]
)
interface ProducerComponent {
    fun inject(producerFragmentProducer: FragmentProducer)
}