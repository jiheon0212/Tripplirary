package com.example.tripplirary_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tripplirary_project.databinding.FragmentPlanBinding

class PlanFragment : Fragment() {

    lateinit var fragmentPlanBinding: FragmentPlanBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPlanBinding = FragmentPlanBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity

        fragmentPlanBinding.run {
            tbPlan.run {
                title = "Pre_Plan"
                inflateMenu(R.menu.plan_menu)
                setOnMenuItemClickListener {
                    mainActivity.replaceFragment(MainActivity.PLAN_ADD_FRAGMENT ,true, true)
                    false
                }
            }
        }

        return fragmentPlanBinding.root
    }
}