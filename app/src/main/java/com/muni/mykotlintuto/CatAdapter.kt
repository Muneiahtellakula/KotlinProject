package com.muni.mykotlintuto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CatAdapter : RecyclerView.Adapter<CatViewHolder>() {
    companion object {
        private val CAT_IMAGE_IDS = intArrayOf(
            R.drawable.cat_1,
            R.drawable.cat_2,
            R.drawable.cat_3,
            R.drawable.cat_4,
            R.drawable.cat_5,
            R.drawable.cat_6,
            R.drawable.cat_7,
            R.drawable.cat_8,
            R.drawable.cat_9,
            R.drawable.cat_10,
            R.drawable.cat_11,
            R.drawable.cat_12,
            R.drawable.cat_13,
            R.drawable.cat_14,
            R.drawable.cat_15,
            R.drawable.cat_16,
            R.drawable.cat_17,
            R.drawable.cat_18,
            R.drawable.cat_19
        )
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cat_viewholder, parent, false)
            return CatViewHolder(view)
        }

        override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
            val pos = position % CAT_IMAGE_IDS.size
            holder.bindTo(CAT_IMAGE_IDS[pos])
        }

        override fun getItemCount() = CAT_IMAGE_IDS.size * 4


}