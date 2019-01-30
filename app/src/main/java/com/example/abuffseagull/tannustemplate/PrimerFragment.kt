package com.example.abuffseagull.tannustemplate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_primer.*

class PrimerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_primer, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        primerText.text = getString(R.string.primer, 6, 1, "box jumps")
        nextButton.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.container, WarmupFragment()).addToBackStack(null).commit()
        }
    }
}
