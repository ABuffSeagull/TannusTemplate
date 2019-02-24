package com.abuffseagull.tannustemplate


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abuffseagull.tannustemplate.databinding.FragmentSetBinding
import kotlinx.android.synthetic.main.fragment_set.*


/**
 * A simple [Fragment] subclass.
 * Use the [SetFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SetFragment : Fragment() {
    lateinit var sharedViewModel: SharedViewModel

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSetBinding.inflate(inflater, container, false)
        sharedViewModel = activity!!.let { ViewModelProviders.of(it).get(SharedViewModel::class.java) }
        binding.viewmodel = sharedViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextSet.setOnClickListener {
            sharedViewModel.currentSet.value = sharedViewModel.currentSet.value!!.plus(1)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SetFragment.
         */
        @JvmStatic
        fun newInstance() = SetFragment()
//            SetFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}
