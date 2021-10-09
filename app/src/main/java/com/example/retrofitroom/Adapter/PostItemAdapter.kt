package com.example.retrofitroom.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitroom.PostDataModel
import com.example.retrofitroom.R

class PostItemAdapter(val context: Context) :
    RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {

    var postList: List<PostDataModel>? = null

    fun submitList(mList: List<PostDataModel>) {
        this.postList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_item,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return postList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        val post = postList?.get(position)
//        holder.title.text = post?.title
//        holder.description.text = post?.body
//        holder.discription.text = postList?.get(position)?.body
        holder.bind(postList?.get(position)!!)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var description = itemView.findViewById<TextView>(R.id.description)
        fun bind(data: PostDataModel) {
            title.text = data.title
            description.text = data.body
        }
    }
}