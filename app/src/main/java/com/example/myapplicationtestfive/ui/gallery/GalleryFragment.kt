package com.example.myapplicationtestfive.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationtestfive.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.status.observe(viewLifecycleOwner) {
            textView.text = it
        }
        binding.fetchAll.setOnClickListener {
            galleryViewModel.getUsers();
        }
        binding.fetchOne.setOnClickListener {
            galleryViewModel.getSingleUser("2");
        }
        binding.insert.setOnClickListener {
            galleryViewModel.createSingleUser("Lorem", "Ipsum");
        }
        binding.update.setOnClickListener {
            galleryViewModel.updateSingleUser("2", "Lorem", "Ipsum");
        }
        binding.delete.setOnClickListener {
            galleryViewModel.deleteSingleUser("2");
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}