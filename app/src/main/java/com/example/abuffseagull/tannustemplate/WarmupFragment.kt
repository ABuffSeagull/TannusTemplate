package com.example.abuffseagull.tannustemplate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
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
        val currentWeight = 2150
        warmupText.text = getString(R.string.warmup_weight, currentWeight / 10)
        var leftoverWeight = (currentWeight - 450) / 2

        for (weight in arrayOf(450, 250, 100, 50, 25)) {
            val count = leftoverWeight / weight
            if (count == 0) continue
            val row = TableRow(context)

            val countView = TextView(context)
            countView.text = count.toString()
            countView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            countView.textSize = 24f
            row.addView(
                countView,
                TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )

            val weightView = TextView(context)
            weightView.text = if (weight == 25) "2.5" else (weight / 10).toString()
            weightView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            weightView.textSize = 24f
            row.addView(
                weightView,
                TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )
            plateLayout.addView(row)
            leftoverWeight -= count * weight
        }

        nextStage.setOnClickListener {
            it.findNavController().navigate(R.id.action_warmupFragment_to_setFragment)
        }
    }
}
