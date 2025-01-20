package com.example.petcareclinic_last.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.models.Pet

class PetAdapter(var context: Context, private var petList: List<Pet>) : BaseAdapter() {
    private var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return petList.size
    }

    override fun getItem(position: Int): Any {
        return petList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = layoutInflater.inflate(R.layout.pet_item, parent, false)

        val petNameTextView = rowView.findViewById<TextView>(R.id.sitterNameTextView)
        val tag1TextView = rowView.findViewById<TextView>(R.id.tag1TextView)
        val tag2TextView = rowView.findViewById<TextView>(R.id.tag2TextView)
        val descriptionTextView = rowView.findViewById<TextView>(R.id.descriptionTextView)

        val pet = petList[position]

        petNameTextView.text = pet.name
        tag1TextView.text = "Playful"
        tag2TextView.text = "Loves company"
        descriptionTextView.text = "Hi, I’m ${pet.name}! ${pet.breed} that loves to play, cuddle, and be the center of attention."

        return rowView
    }
}
