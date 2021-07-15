package com.example.mediatorexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediatorexample.R
import com.example.mediatorexample.model.Animals
import kotlinx.android.synthetic.main.animals_item.view.*

class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animals = listOf<Animals>()

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(animal: Animals) {
            itemView.tv_item_name.text = animal.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.animals_item, parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.onBind(animals[position])
    }

    override fun getItemCount(): Int = animals.size

    fun setNote(animals: List<Animals>) {
        this.animals = animals
        notifyDataSetChanged()
    }
}