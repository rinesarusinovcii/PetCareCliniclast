package com.example.petcareclinic_last.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
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

        val sitterImageView = rowView.findViewById<ImageView>(R.id.picPet)
        val sitterNameTextView = rowView.findViewById<TextView>(R.id.name)
        val sitterEmailTextView = rowView.findViewById<TextView>(R.id.characteristics)
        val sitterPhoneTextView = rowView.findViewById<TextView>(R.id.breed)
        val sitterDescriptionTextView = rowView.findViewById<TextView>(R.id.description)

        val pet = petList[position]
//        sitterImageView.setImageResource(sitterList[position].picture)
        sitterImageView.setImageResource(pet.petPic)
        sitterNameTextView.text = pet.name
        sitterEmailTextView.text = pet.breed
        sitterPhoneTextView.text = pet.characteristic
        sitterDescriptionTextView.text = pet.descriptionPet

        return rowView
    }
}
