package com.driouechemed.basicjavaapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.driouechemed.basicjavaapp.database.entities.Task;
import com.driouechemed.basicjavaapp.databinding.FragmentEnterTaskBinding;

import org.apache.commons.lang3.StringUtils;

public class EnterTaskFragment extends Fragment {

    private FragmentEnterTaskBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentEnterTaskBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.validateButton.setOnClickListener(v -> onValidateClick());
    }

    private void onValidateClick() {
        Task userTask = new Task(binding.taskName.getText().toString(),
                binding.taskDetails.getText().toString());

        binding.taskName.setText(StringUtils.EMPTY);
        binding.taskDetails.setText(StringUtils.EMPTY);
    }
}
