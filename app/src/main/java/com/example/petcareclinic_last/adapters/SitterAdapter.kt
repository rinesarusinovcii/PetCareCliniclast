package com.example.petcareclinic_last.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.models.Sitter

class SitterAdapter(var context: Context, private var sitterList: List<Sitter>) : BaseAdapter() {
    private var layoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return sitterList.size
    }

    override fun getItem(position: Int): Any {
        return sitterList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = layoutInflater.inflate(R.layout.sitter_item, parent, false)

        val sitterImageView = rowView.findViewById<ImageView>(R.id.picSitter)
        val sitterNameTextView = rowView.findViewById<TextView>(R.id.name)
        val sitterEmailTextView = rowView.findViewById<TextView>(R.id.email)
        val sitterPhoneTextView = rowView.findViewById<TextView>(R.id.number)
        val sitterDescriptionTextView = rowView.findViewById<TextView>(R.id.description)

        val sitter = sitterList[position]
//        sitterImageView.setImageResource(sitterList[position].picture)
        sitterImageView.setImageResource(sitter.picture)
        sitterNameTextView.text = sitter.name
        sitterEmailTextView.text = sitter.email
        sitterPhoneTextView.text = sitter.phoneNumber
        sitterDescriptionTextView.text = sitter.descriptionSitter

        return rowView
    }
}




