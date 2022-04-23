package com.driouechemed.basicjavaapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.driouechemed.basicjavaapp.R;
import com.driouechemed.basicjavaapp.database.entities.Task;
import com.driouechemed.basicjavaapp.databinding.FragmentEnterTaskBinding;
import com.driouechemed.basicjavaapp.viewmodel.TaskViewModel;

import org.apache.commons.lang3.StringUtils;

public class EnterTaskFragment extends Fragment {

    private FragmentEnterTaskBinding binding;
    private TaskAdapter taskAdapter;
    private TaskViewModel taskViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        taskAdapter = new TaskAdapter();
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getTasksFromDb();

        binding = FragmentEnterTaskBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        taskViewModel.getTasks().observe(getViewLifecycleOwner(), taskAdapter::addTasks);

        binding.validateButton.setOnClickListener(v -> onValidateClick());
        binding.taskList.setAdapter(taskAdapter);
    }

    private void onValidateClick() {
        if (binding.taskName.getEditText() != null) {
            if (StringUtils.isEmpty(binding.taskName.getEditText().getText().toString())) {
                binding.taskName.getEditText().setError(getString(R.string.mandatory_field));
            } else {
                insertTask();
                clearInputs();
            }
        }
    }

    private void insertTask() {
        Task userTask = new Task(binding.taskName.getEditText().getText().toString(),
                binding.taskDetails.getEditText().getText().toString());
        taskViewModel.insert(userTask);
    }

    private void clearInputs() {
        binding.taskName.getEditText().clearFocus();
        binding.taskDetails.getEditText().clearFocus();

        binding.taskName.getEditText().getText().clear();
        binding.taskDetails.getEditText().getText().clear();
    }
}
