package com.example.tripplirary_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tripplirary_project.databinding.FragmentPlanAddBinding

class PlanAddFragment : Fragment() {

    lateinit var fragmentPlanAddBinding: FragmentPlanAddBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPlanAddBinding = FragmentPlanAddBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity

        fragmentPlanAddBinding.run {
            tbPlanAdd.run {
                title = "Pre_PlanAdd"

                // backstack 에서 해당 fragment 삭제 후 이전으로 복귀
                // todo : 돌아가기전에 사용자에게 dialog로 내용 저장 안된다는 것 고지하기
                setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
                setNavigationOnClickListener{
                    mainActivity.removeFragment(MainActivity.PLAN_ADD_FRAGMENT)
                }
            }
        }

        return fragmentPlanAddBinding.root
    }
}