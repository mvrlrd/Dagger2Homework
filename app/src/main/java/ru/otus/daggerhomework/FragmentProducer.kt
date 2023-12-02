package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.components.DaggerProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {
    @Inject
    lateinit var viewModel: ViewModelProducer

    override fun onAttach(context: Context) {
        DaggerProducerComponent.builder()
            .activityComponent((requireActivity() as MainActivity).activityComponent)
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
            //отправить результат через livedata в другой фрагмент
        }
    }
}