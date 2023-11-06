package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.components.ActivityComponent

class MainActivity : AppCompatActivity() {

    val activityComponent: ActivityComponent by lazy {
        ActivityComponent.getActivityComponent(
            (application as App).getApplicationComponent(),
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)
    }
}