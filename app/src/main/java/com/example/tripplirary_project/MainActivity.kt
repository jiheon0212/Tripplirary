package com.example.tripplirary_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tripplirary_project.databinding.ActivityMainBinding
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    companion object {
        val HOME_FRAGMENT = "HomeFragment"
        val POST_FRAGMENT = "PostFragment"
        val POST_ADD_FRAGMENT = "PostAddFragment"
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
                        // 화면 5가지 구성 bottomnavigation
                        R.id.itemHome -> replaceFragment(HOME_FRAGMENT, false ,false)
                        R.id.itemPost -> replaceFragment(POST_FRAGMENT, false ,false)
                        R.id.itemPlan -> replaceFragment(PLAN_FRAGMENT, false ,false)
                        R.id.itemShare -> replaceFragment(SHARE_FRAGMENT, false ,false)
                        R.id.itemMy -> replaceFragment(MY_FRAGMENT, false ,false)
                    }
                    true
                }
            }
        }

        setContentView(activityMainBinding.root)
    }
    // todo : fragment 전환 애니메이션 추가하기
    // todo : splash 화면 설정 및 앱 아이콘 & 이름 변경하기

    // fragment 전환용 메서드
    fun replaceFragment(name: String, addToBackStack: Boolean, animate: Boolean){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var newFragment = when(name){
            HOME_FRAGMENT -> HomeFragment()
            POST_FRAGMENT -> PostFragment()
            PLAN_FRAGMENT -> PlanFragment()
            SHARE_FRAGMENT -> ShareFragment()
            MY_FRAGMENT -> MyFragment()
            PLAN_ADD_FRAGMENT -> PlanAddFragment()
            POST_ADD_FRAGMENT -> PostAddFragment()

            else -> Fragment()
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

    // fragment 백 스텍 삭제 메서드
    fun removeFragment(name:String){
        supportFragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
    fun postReadJson(){

    }
}