package com.example.stores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stores.databinding.ItemStoreBinding

class StoreAdapter (private var stores: MutableList<StoreEntity>, private var listener: OnClickListener ):RecyclerView.Adapter<StoreAdapter.ViewHolder>(){

        private lateinit var mContext:Context

    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view){
            val binding= ItemStoreBinding.bind(view)
        fun setListener(storeEntity:StoreEntity){
            binding.root.setOnClickListener { listener.OnClick(storeEntity) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext=parent.context
        val view= LayoutInflater.from(mContext).inflate(R.layout.item_store,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =  stores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=stores[position]
      with(holder) {
          setListener(item)
            binding.tvName.text=item.name
        }
    }

    fun add(storeEntity: StoreEntity) {
        stores.add(storeEntity)
        notifyDataSetChanged()
    }
}