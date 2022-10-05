package com.example.testtaskvrg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskvrg.R
import com.example.testtaskvrg.View.model.DisplayablePost
import com.example.testtaskvrg.until.DataBindingUtil
import com.example.testtaskvrg.databinding.ItemPostBinding

class PostsAdapter(private val posts: List<DisplayablePost>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ItemPostBinding>(layoutInflater, R.layout.activity_post_information_details, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        holder?.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: DisplayablePost) {
            binding.post = post
        }
    }
}