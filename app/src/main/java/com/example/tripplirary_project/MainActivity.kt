package com.example.tripplirary_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tripplirary_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    companion object {
        val HOME_FRAGMENT = "HomeFragment"
        val POST_FRAGMENT = "PostFragment"
        val PLAN_FRAGMENT = "PlanFragment"
        val PLAN_ADD_FRAGMENT = "PlanAddFragment"
        val SHARE_FRAGMENT = "ShareFragment"
        val MY_FRAGMENT = "MyFragment"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding.run {
            bnViewMain.run {
                setOnItemSelectedListener {
                    when (it.itemId){
                        R.id.itemHome -> {
                            replaceFragment(HOME_FRAGMENT, false ,false)
                        }
                        R.id.itemPost -> {
                            replaceFragment(POST_FRAGMENT, false ,false)
                        }
                        R.id.itemPlan -> {
                            replaceFragment(PLAN_FRAGMENT, false ,false)
                        }
                        R.id.itemShare -> {
                            replaceFragment(SHARE_FRAGMENT, false ,false)
                        }
                        R.id.itemMy -> {
                            replaceFragment(MY_FRAGMENT, false ,false)
                        }
                    }
                    true
                }
            }
        }

        setContentView(activityMainBinding.root)
    }
    fun replaceFragment(name: String, addToBackStack: Boolean, animate: Boolean){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var newFragment = when(name){
            HOME_FRAGMENT -> {
                HomeFragment()
            }
            POST_FRAGMENT -> {
                PostFragment()
            }
            PLAN_FRAGMENT -> {
                PlanFragment()
            }
            SHARE_FRAGMENT -> {
                ShareFragment()
            }
            MY_FRAGMENT -> {
                MyFragment()
            }
            PLAN_ADD_FRAGMENT -> {
                PlanAddFragment()
            }
            else -> {
                Fragment()
            }
        }

        fragmentTransaction.replace(R.id.fcvMain, newFragment)
        if (animate) {
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(name)
        }
        fragmentTransaction.commit()
    }

    fun removeFragment(name:String){
        supportFragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}