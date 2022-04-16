package com.driouechemed.basicjavaapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.driouechemed.basicjavaapp.databinding.FragmentEnterTaskBinding;

public class EnterTaskFragment extends Fragment {

    private FragmentEnterTaskBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentEnterTaskBinding.inflate(inflater);
        return binding.getRoot();
    }
}
