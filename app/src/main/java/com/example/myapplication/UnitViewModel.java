package com.example.myapplication;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class UnitViewModel extends AndroidViewModel {
    private final UnitRepositorio unitRepositorio;

    public UnitViewModel(@NonNull Application application) {
        super(application);

        unitRepositorio = new UnitRepositorio(application);
    }

    public void insertar(String nombre, String apodo, Uri imagenSeleccionada) {
        unitRepositorio.insertar(nombre, apodo,imagenSeleccionada);
    }
}
