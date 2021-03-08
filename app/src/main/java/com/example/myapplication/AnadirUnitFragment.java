package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.FragmentMostrarUnitBinding;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static androidx.core.content.ContextCompat.checkSelfPermission;


public class AnadirUnitFragment extends Fragment {
    private FragmentMostrarUnitBinding binding;
    private NavController navController;
    private Uri imagenSeleccionada;
    private UnitViewModel unitViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarUnitBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        unitViewModel = new ViewModelProvider(requireActivity()).get(UnitViewModel.class);

        binding.fotoUnit.setOnClickListener(v -> {
            abrirGaleria();
        });

        binding.insertar.setOnClickListener(v ->{
            String nombre = binding.Nombre.getText().toString();
            String apodo = binding.apodo.getText().toString();

            unitViewModel.insertar(nombre, apodo, imagenSeleccionada);
            navController.popBackStack();

        });
    }

    private void abrirGaleria(){

        if(checkSelfPermission(requireContext(), READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED){
            lanzadorGaleria.launch("image/*");
        }else{
            lanzadorPermisos.launch(READ_EXTERNAL_STORAGE);
        }

    }
    private final ActivityResultLauncher<String> lanzadorGaleria =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri ->{
                unitViewModel.establecerImagenSeleccionada(uri);
                imagenSeleccionada = uri;
                Glide.with(requireView()).load(uri).into(binding.fotoUnit);
            });


    private final ActivityResultLauncher<String> lanzadorPermisos = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted ->{
        if(isGranted){
            lanzadorGaleria.launch("image/*");
        }
    });
}