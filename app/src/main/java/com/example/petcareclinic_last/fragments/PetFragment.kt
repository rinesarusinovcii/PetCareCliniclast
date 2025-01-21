package com.example.petcareclinic_last.fragments

import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.adapters.PetAdapter
import com.example.petcareclinic_last.adapters.SitterAdapter
import com.example.petcareclinic_last.databinding.PetFragmentBinding
import com.example.petcareclinic_last.models.Pet
import com.example.petcareclinic_last.models.Sitter
import retrofit2.Callback
import retrofit2.Response

class PetFragment : Fragment() {
    private lateinit var binding: PetFragmentBinding
    private var petList: List<Pet> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PetFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define the sitter list
        val petList = listOf(
            Pet(
                1,
                R.drawable.pet_1,
                "Bella",
                "Golden Retriever",
                "Friendly and loyal",
                "Bella is a playful and affectionate dog known for her gentle nature and warm disposition. She thrives in the company of people, especially children, and enjoys outdoor activities like running, hiking, and swimming. Bella has an uncanny ability to sense emotions and is often used as a therapy dog because of her calming presence."
            ),
            Pet(
                2,
                R.drawable.pet_2,
                "Max",
                "Siamese Cat",
                "Vocal and curious",
                "Max is a strikingly beautiful cat with a sleek coat and piercing blue eyes. He is highly social and loves to engage in 'conversations' with his humans. Curious by nature, Max explores every corner of his home, often making it a point to observe what everyone is up to. His playful antics and expressive personality make him a delight to have around."
            ),
            Pet(
                3,
                R.drawable.pet_3,
                "Charlie",
                "Beagle",
                "Energetic and curious",
                "Charlie is a spirited and inquisitive dog who is always on the move. His excellent sense of smell often leads him on adventures, whether it’s in the backyard or on a trail. Beagles like Charlie are great companions for families with an active lifestyle. He is highly sociable, gets along well with other pets, and loves to play fetch."
            ),
            Pet(
                4,
                R.drawable.pet_4,
                "Luna",
                "Persian Cat",
                "Calm and affectionate",
                "Luna is a regal and serene cat who enjoys the quieter side of life. With her long, luxurious coat and expressive eyes, she is the epitome of elegance. Luna loves being pampered with gentle brushing and affectionate cuddles. Despite her laid-back nature, she has moments of playful energy and enjoys chasing toys around the house."
            ),
            Pet(
                5,
                R.drawable.pet_5,
                "Rocky",
                "Boxer",
                "Playful and protective",
                "Rocky is an energetic and strong dog with a big heart. He forms deep bonds with his family and is known for his loyalty and protective instincts. Rocky loves outdoor activities and enjoys games like tug-of-war and fetch. His playful personality is matched by his keen awareness of his surroundings, making him both a fun and reliable companion."
            ),
            Pet(
                6,
                R.drawable.pet_6,
                "Daisy",
                "Shih Tzu",
                "Sweet and sociable",
                "Daisy is a small dog with a big personality. Her cheerful demeanor makes her the center of attention wherever she goes. She loves being around people and is always ready to greet visitors with wagging tails and happy barks. Daisy enjoys being pampered and often curls up on laps for long cuddles. Despite her small size, she has a brave spirit and is always curious about her surroundings."
            ),
            Pet(
                7,
                R.drawable.pet_7,
                "Simba",
                "Maine Coon",
                "Gentle giant",
                "Simba is a majestic and affectionate cat who impresses everyone with his large size and fluffy coat. Known as the 'gentle giant' of the cat world, Simba is very friendly and enjoys being around people. He is highly intelligent and loves interactive toys and puzzles. Though he’s playful, he also has a calm side and enjoys relaxing in sunny spots or cozy corners."
            ),
            Pet(
                8,
                R.drawable.pet_8,
                "Coco",
                "Dachshund",
                "Brave and curious",
                "Coco is a lively and adventurous dog who doesn’t let her small size hold her back. Her long body and short legs give her a unique and adorable appearance. Coco is fearless and loves to explore, sniffing out new scents and uncovering hidden treasures. She is incredibly loyal to her family and enjoys cuddling after a day full of activities."
            ),
            Pet(
                9,
                R.drawable.pet_9,
                "Oliver",
                "Labrador Retriever",
                "Intelligent and friendly",
                "Oliver is a highly intelligent and good-natured dog who excels in both learning new tricks and forming strong bonds with his family. Labradors like Oliver are known for their versatility, and he is no exception. He loves swimming, running, and playing games like fetch. His friendly demeanor makes him a great companion for families with children or other pets."
            ),
            Pet(
                10,
                R.drawable.pet_10,
                "Mia",
                "Ragdoll Cat",
                "Relaxed and affectionate",
                "Mia is a beautiful and relaxed cat who adores being the center of attention. True to her breed, she is incredibly affectionate and loves to be carried around like a doll, often going limp in her owner’s arms. Mia enjoys spending her time lounging on soft cushions or by sunny windows, observing the world outside. She’s gentle with children and loves being petted."
            )
        )

        // Set up the ListView with a custom adapter
        val adapter = PetAdapter(requireContext(), petList)
        binding.listViewPetList.adapter = adapter

        // Handle item clicks (optional)
        binding.listViewPetList.setOnItemClickListener { _, _, position, _ ->
            val sitter = petList[position]
            // Show a toast or perform an action
            Toast.makeText(requireContext(), "Clicked: ${sitter.name}", Toast.LENGTH_SHORT).show()
        }
    }





}