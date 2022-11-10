package com.example.lesson5.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson5.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()

    private val gifAdapter = GifAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = gifAdapter
        }
        val stub = view.findViewById<TextView>(R.id.stub)

        viewLifecycleOwner.lifecycleScope.launch {
            stub.isVisible = true
            stub.text = "Pending"
            stub.setOnClickListener(null)

            try {
                val list = withContext(Dispatchers.IO) {viewModel.getGiphy()}
                gifAdapter.submitList(list as List<Image>)

                stub.isVisible = false
            } catch (error: Throwable){
                stub.isVisible = true
                stub.text = "ERROR: ${error.message}"
                error.printStackTrace()
                stub.setOnClickListener {

                }
            }
        }
    }

}