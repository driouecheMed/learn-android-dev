package com.driouechemed.basickotlinapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.driouechemed.basickotlinapp.databinding.FragmentEnterTaskBinding

class EnterTaskFragment : Fragment() {

    private lateinit var binding: FragmentEnterTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentEnterTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
}