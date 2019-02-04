package com.example.abuffseagull.tannustemplate

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_warmup.*

class WarmupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_warmup, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // NOTE: everything is * 10 so that it's all ints
        val currentWeight = 2250
        warmupText.text = getString(R.string.warmup_weight, currentWeight / 10)
        var leftoverWeight = (currentWeight - 450) / 2
        var lastId = 0

        val constraintSet = ConstraintSet()
        constraintSet.clone(warmupLayout)
        for (weight in arrayOf(450, 250, 100, 50, 25)) {
            val count = leftoverWeight / weight
            if (count != 0) {
                val countView = TextView(context)
                countView.text = count.toString()
                countView.id = View.generateViewId()
                countView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                countView.textSize = 24f
                warmupLayout.addView(countView)
                constraintSet.constrainHeight(countView.id, ConstraintSet.WRAP_CONTENT)
                constraintSet.constrainWidth(countView.id, ConstraintSet.WRAP_CONTENT)
                constraintSet.connect(
                    countView.id,
                    ConstraintSet.TOP,
                    if (lastId != 0) lastId else countTitle.id,
                    ConstraintSet.BOTTOM,
                    8
                )

                val weightView = TextView(context)
                weightView.text = if (weight == 25) "2.5" else (weight / 10).toString()
                weightView.id = View.generateViewId()
                weightView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                weightView.textSize = 24f
                warmupLayout.addView(weightView)
                constraintSet.constrainHeight(weightView.id, ConstraintSet.WRAP_CONTENT)
                constraintSet.constrainWidth(weightView.id, ConstraintSet.WRAP_CONTENT)
                constraintSet.centerVertically(weightView.id, countView.id)

                constraintSet.createHorizontalChain(
                    ConstraintSet.PARENT_ID,
                    ConstraintSet.LEFT,
                    ConstraintSet.PARENT_ID,
                    ConstraintSet.RIGHT,
                    intArrayOf(countView.id, weightView.id),
                    floatArrayOf(1f, 1f),
                    ConstraintSet.CHAIN_SPREAD
                )

                constraintSet.centerHorizontally(countView.id, if (lastId != 0) lastId else countTitle.id)
                constraintSet.constrainHeight(countView.id, ConstraintSet.WRAP_CONTENT)
                lastId = countView.id
            }
            leftoverWeight -= count * weight
        }
        constraintSet.applyTo(warmupLayout)

        nextStage.setOnClickListener {
            it.findNavController().navigate(R.id.action_warmupFragment_to_setFragment)
        }
    }
}
