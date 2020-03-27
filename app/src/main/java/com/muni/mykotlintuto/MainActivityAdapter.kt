package com.muni.mykotlintuto

import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
class MainActivityAdapter(private var items: ArrayList<UserDto>): RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemView = from(parent?.context)
            .inflate(R.layout.row_layout_mainactivity, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var userDto = items[position]
        holder?.txtName?.text = userDto.name
        holder?.txtComment?.text = userDto.comment

    }
    class ViewHolder(row: View) : RecyclerView.ViewHolder(row)  {
        var txtName: TextView? = null
        var txtComment: TextView? = null

        init {
            this.txtName = row?.findViewById<TextView>(R.id.tv_name)
            this.txtComment = row?.findViewById<TextView>(R.id.tv_commit)
        }
    }
}
