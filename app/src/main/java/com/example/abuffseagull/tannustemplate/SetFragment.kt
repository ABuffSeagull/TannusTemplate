package com.example.abuffseagull.tannustemplate


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_set.*


/**
 * A simple [Fragment] subclass.
 * Use the [SetFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SetFragment : Fragment() {
    var currentSet = 1
    var maxSets = 5

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
//        val binding = DataBindingUtil.inflate<FragmentSetBinding>(inflater, R.layout.fragment_set, container, false)
//        val binding = FragmentSetBinding.inflate(inflater, container, false)
//        binding.currentSet = this
//        return binding.root
        return inflater.inflate(R.layout.fragment_set, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCounter.text = getString(R.string.set_counter, currentSet, maxSets)
        nextSet.setOnClickListener {
            if (currentSet < maxSets) {
                currentSet += 1
                setCounter.text = getString(R.string.set_counter, currentSet, maxSets)
            } else {
                // TODO: move on to next thing
            }
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
