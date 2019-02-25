package com.juniar.ancodev.android_boilerplate.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class GeneralRecyclerViewAdapter<T>(
    @LayoutRes private val resId: Int,
    private val data: MutableList<T>,
    private val listener: (T, position: Int, View) -> Unit = { _, _, _ -> kotlin.run {} },
    private val viewHolderBindAction: (T, View) -> Unit = { _, _ -> kotlin.run {} }
) :
    RecyclerView.Adapter<GeneralRecyclerViewAdapter.GeneralViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder<T> {
        return GeneralViewHolder(LayoutInflater.from(parent.context).inflate(resId, parent, false))
    }

    override fun onBindViewHolder(holder: GeneralViewHolder<T>, position: Int) {
        holder.bind(data[position], listener, viewHolderBindAction)
    }

    override fun getItemCount() = data.size

    class GeneralViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(any: T, listener: (T, position: Int, View) -> Unit, viewHolderBindAction: (T, View) -> Unit) =
            with(itemView) {
                viewHolderBindAction(any, itemView)
                setOnClickListener { listener(any, adapterPosition, itemView) }
            }
    }

}