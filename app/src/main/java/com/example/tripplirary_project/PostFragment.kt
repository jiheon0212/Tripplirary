package com.example.tripplirary_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tripplirary_project.databinding.FragmentPostBinding
import com.example.tripplirary_project.databinding.PostRowBinding
import org.w3c.dom.Text

class PostFragment : Fragment() {

    lateinit var fragmentPostBinding: FragmentPostBinding
    lateinit var mainActivity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPostBinding = FragmentPostBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity

        fragmentPostBinding.run {
            tbPost.run {
                title = "Pre_Post"
                inflateMenu(R.menu.post_menu)
                setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.postAdd -> mainActivity.replaceFragment(MainActivity.POST_ADD_FRAGMENT, true, true)
                        R.id.postSearch -> {

                        }
                    }
                    false
                }
            }
            recyclerPost.run {
                adapter = PostAdapter()
                layoutManager = LinearLayoutManager(mainActivity)
            }
        }

        return fragmentPostBinding.root
    }
    inner class PostAdapter: RecyclerView.Adapter<PostAdapter.PostHolder>(){
        inner class PostHolder(postRowBinding: PostRowBinding): RecyclerView.ViewHolder(postRowBinding.root){
            var nickname: TextView
            var date: TextView
            var text: TextView
            init {
                nickname = postRowBinding.tvPostNickname
                date = postRowBinding.tvPostDate
                text = postRowBinding.tvPostText

                postRowBinding.btnLike.setOnClickListener {

                }
                postRowBinding.btnComment.setOnClickListener {

                }
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
            val postRowBinding = PostRowBinding.inflate(layoutInflater)
            val viewHolder = PostHolder(postRowBinding)

            return viewHolder
        }
        override fun getItemCount(): Int {
            return 5
        }
        override fun onBindViewHolder(holder: PostHolder, position: Int) {
            holder.nickname.text = "Leejiheon"
            holder.date.text = "23.07.26 15:16"
            holder.text.text = "TestTestTestTestTestTestTestTestTestTestTestTestTestTest"
        }
    }
}