package com.example.restapiproject_gr2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.restapiproject_gr2.databinding.FragmentSlideshowBinding
import com.example.restapiproject_gr2.viewmodels.SlideshowViewModel

class SlideshowFragment : Fragment() {

    private lateinit var binding: FragmentSlideshowBinding
    private lateinit var viewModel: SlideshowViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SlideshowViewModel::class.java]

        viewModel.count.observe(viewLifecycleOwner) { countValue ->
            binding.tvShowCount.text = "Count is : $countValue"
        }

        binding.btnIncreaseCountBy1.setOnClickListener {
            viewModel.count.value = viewModel.count.value?.plus(1)
        }

        binding.btnIncreaseCountBy2.setOnClickListener {
            viewModel.count.value = viewModel.count.value?.plus(2)
        }

    }
}