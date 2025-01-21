
package com.example.petcareclinic_last.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.adapters.SitterAdapter
import com.example.petcareclinic_last.databinding.SitterFragmentBinding
import com.example.petcareclinic_last.models.Sitter

class SitterFragment : Fragment() {
    private lateinit var binding: SitterFragmentBinding
//    private  var sitterList: List<Sitter> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SitterFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define the sitter list
        val sitterList = listOf(
            Sitter(
                1,
                R.drawable.person1.toString(),
                "Sarah Johnson",
                "sarah.johnson@gmail.com",
                "+1 555-234-6789",
                "Sarah is a compassionate and experienced pet sitter..."
            ),
            Sitter(
                2,
                R.drawable.person2.toString(),
                "Mark Reynolds",
                "mark.reynolds@petsafe.com",
                "+1 555-987-3456",
                "Mark is a reliable and enthusiastic pet sitter..."
            ),
            Sitter(
                3,
                R.drawable.person_3.toString(),
                "Emily Carter",
                "emily.carter@happytails.com",
                "+1 555-456-7890",
                "Emily is a dedicated pet sitter specializing in caring for cats..."
            ),
            Sitter(
                4,
                R.drawable.person4.toString(),
                "James Bennett",
                "james.bennett@petbuddy.com",
                "+1 555-321-6547",
                "James is a dependable and professional pet sitter..."
            ),
            Sitter(
                5,
                R.drawable.person_5.toString(),
                "Olivia Martinez",
                "olivia.martinez@pawcare.com",
                "+1 555-678-2345",
                "Olivia is a kind and attentive pet sitter..."
            )
        )

        // Set up the ListView with a custom adapter
        val adapter = SitterAdapter(requireContext(), sitterList)
        binding.listViewPetList.adapter = adapter

        // Handle item clicks (optional)
        binding.listViewPetList.setOnItemClickListener { _, _, position, _ ->
            val sitter = sitterList[position]
            // Show a toast or perform an action
            Toast.makeText(requireContext(), "Clicked: ${sitter.name}", Toast.LENGTH_SHORT).show()
        }
    }
}
