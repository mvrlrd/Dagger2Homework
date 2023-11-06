package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.ProducerScope
import ru.otus.daggerhomework.di.modules.ProducerModule

@ProducerScope
@Component(
    modules = [ProducerModule::class],
    dependencies = [ActivityComponent::class]
)
interface ProducerComponent {
    fun inject(producerFragmentProducer: FragmentProducer)
}