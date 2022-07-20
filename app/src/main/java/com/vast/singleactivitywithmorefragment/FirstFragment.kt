package com.vast.singleactivitywithmorefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.vast.singleactivitywithmorefragment.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FirstFragment : Fragment() {
    private val count: Int by requireExtra(COUNT)

    private val vm: ViewModel by viewModel {
        parametersOf(
            count
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(
            inflater,
            container,
            false
        )

        vm.liveData.observe(viewLifecycleOwner) {
            binding.tvsf.text = it.toString()
        }

        binding.apply {
            bsf.setOnClickListener {
                val secondFragment = SecondFragment.newInstance(tvsf.text.toString().toInt().inc())
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainerView, secondFragment)
                    .commit()
            }
        }
        return binding.root
    }

    companion object {
        private const val COUNT = "count"

        fun newInstance(count: Int) =
            FirstFragment().apply {
                arguments = bundleOf(COUNT to count)
            }
    }
}