package com.vast.singleactivitywithmorefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.vast.singleactivitywithmorefragment.databinding.FragmentSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SecondFragment: Fragment() {
    private val count: Int by requireExtra(COUNT)

    private val viewModel: ViewModel by viewModel {
        parametersOf(count)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(
            inflater,
            container,
            false
        )

        viewModel.navigateCounterLiveData.observe(viewLifecycleOwner) {
            binding.navigateCounterTextView.text = it.toString()
        }

        binding.apply {
            buttonNavigateToFirstFragment.setOnClickListener {
                val count: Int = navigateCounterTextView.text.toString().toInt().inc()
                val firstFragment = FirstFragment.newInstance(count)
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainerView, firstFragment)
                    .commit()
            }
        }

        return binding.root
    }

    companion object {
        private const val COUNT = "count"

        fun newInstance(count: Int) =
            SecondFragment().apply {
                arguments = bundleOf(COUNT to count)
            }
    }
}