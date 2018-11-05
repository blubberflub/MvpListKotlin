package com.blub.mvplistkotlin.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.blub.mvplistkotlin.R
import com.blub.mvplistkotlin.model.Animal

class ViewAdapter(private val mAnimalList: List<Animal>,
                  private val mListener: AnimalTouchListener) :
        RecyclerView.Adapter<ViewAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animals, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(animalViewHolder: AnimalViewHolder, position: Int) {
        animalViewHolder.animalName.text = mAnimalList[position].name
        animalViewHolder.animal.setOnClickListener { view ->
            mListener.onItemClicked(mAnimalList[position], view) }

    }

    override fun getItemCount(): Int {
        return mAnimalList.size
    }

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var animal: LinearLayout = itemView.findViewById(R.id.animal)
        var animalName: TextView = itemView.findViewById(R.id.animal_name)

    }

    interface AnimalTouchListener {
        fun onItemClicked(animal: Animal, view: View)
    }
}
