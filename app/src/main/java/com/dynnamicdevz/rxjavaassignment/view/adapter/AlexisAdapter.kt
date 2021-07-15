package com.dynnamicdevz.rxjavaassignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynnamicdevz.rxjavaassignment.databinding.GridRepoItemLayoutBinding
import com.dynnamicdevz.rxjavaassignment.databinding.ListRepoItemLayoutBinding
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponseItem
import com.dynnamicdevz.rxjavaassignment.util.ViewType

class AlexisAdapter(private val vType: ViewType, private val delegate: AlexisDelegate) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface AlexisDelegate{
        fun selectRepo(result: AlexisResponseItem)
    }

    inner class GridViewHolder(val binding: GridRepoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ListViewHolder(val binding: ListRepoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    var listResults = listOf<AlexisResponseItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (vType == ViewType.lIST) {
            ListViewHolder(
                ListRepoItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else
            GridViewHolder(
                GridRepoItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val result = listResults[position]

        if(holder is GridViewHolder){

            holder.binding.root.setOnClickListener{
                delegate.selectRepo(result)
            }

            holder.binding.repoItemName.text = result.name
        }else if(holder is ListViewHolder){

            holder.binding.root.setOnClickListener{
                delegate.selectRepo(result)
            }

            holder.binding.repoItemName.text = result.name
        }
    }

    override fun getItemCount(): Int = listResults.size
}