package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import com.example.myapplication.databinding.FragmentMostrarUnitBinding;


public class MostrarUnitFragment extends Fragment {
    private FragmentMostrarUnitBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarUnitBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UnitListViewModel unitListViewModel = new ViewModelProvider(requireActivity()).get(UnitListViewModel.class);

        unitListViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<UnitList>() {
            @Override
            public void onChanged(UnitList unitList) {

            }
        });
    }
}