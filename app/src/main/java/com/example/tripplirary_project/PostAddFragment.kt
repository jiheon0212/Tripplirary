package com.example.tripplirary_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tripplirary_project.databinding.FragmentPostAddBinding

class PostAddFragment : Fragment() {

    lateinit var fragmentPostAddBinding: FragmentPostAddBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPostAddBinding = FragmentPostAddBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity

        fragmentPostAddBinding.run {
            tbPostAdd.run {
                title = "Pre_Post_Add"
                inflateMenu(R.menu.post_add_menu)
                setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
                setNavigationOnClickListener{
                    mainActivity.removeFragment(MainActivity.POST_ADD_FRAGMENT)
                }
                setOnMenuItemClickListener {
                    mainActivity.replaceFragment(MainActivity.POST_FRAGMENT, false, true)
                    false
                }
            }
        }

        return fragmentPostAddBinding.root
    }
}