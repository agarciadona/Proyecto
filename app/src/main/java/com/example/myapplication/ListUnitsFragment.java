package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentListUnitsBinding;
import com.example.myapplication.databinding.FragmentUnitDisplayBinding;
import com.example.myapplication.databinding.ViewholderUnitlistBinding;

import java.util.List;

public class ListUnitsFragment extends Fragment {

    private FragmentListUnitsBinding binding;

    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListUnitsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.imageButton3.setOnClickListener(v -> navController.popBackStack());

        binding.irAInsertarAlbum.setOnClickListener(v ->{
        navController.navigate(R.id.action_listUnitsFragment_to_mostrarUnitFragment);

        } );
    }


        }
