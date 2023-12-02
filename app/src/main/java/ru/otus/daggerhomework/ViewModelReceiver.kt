package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.color_manager.ColorObserver
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val colorObserver: ColorObserver,
    private val context: Context
) {
    private val _backgroundLiveData = MutableLiveData<Int>()
    val backgroundLiveData: LiveData<Int> get() = _backgroundLiveData

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        CoroutineScope(Dispatchers.Main).launch {
            colorObserver.getObservable().collect{
                _backgroundLiveData.value = it
            }
        }
    }
}