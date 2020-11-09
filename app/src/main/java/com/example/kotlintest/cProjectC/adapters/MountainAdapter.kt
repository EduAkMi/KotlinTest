package com.example.kotlintest.cProjectC.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.R
import com.example.kotlintest.cProjectC.model.Mountain
import com.squareup.picasso.Picasso

class MountainAdapter(private val mountainList: List<Mountain>) : RecyclerView.Adapter<MountainAdapter.MountainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MountainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_single_mountain, parent, false)
        return MountainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MountainViewHolder, position: Int) {
        Picasso.get().load(mountainList[position].image).into(holder.imgImg)
        holder.txtName.text = mountainList[position].name
        holder.txtLocation.text = mountainList[position].location
        holder.txtHeight.text = mountainList[position].height

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Esta é a montanha: ${mountainList[position].name}" , Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mountainList.size
    }

    class MountainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImg: ImageView = itemView.findViewById(R.id.imgRecyclerMountain)
        val txtName: TextView = itemView.findViewById(R.id.txtRecyclerMountainName)
        val txtLocation: TextView = itemView.findViewById(R.id.txtRecyclerMountainLocation)
        val txtHeight: TextView = itemView.findViewById(R.id.txtRecyclerMountainHeight)
    }
}