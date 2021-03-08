package com.example.myapplication;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UnitViewModel extends AndroidViewModel {
    UnitRepositorio unitRepositorio;
    MutableLiveData<Uri> imagenSeleccionada = new MutableLiveData<>();

    public UnitViewModel(@NonNull Application application) {
        super(application);

        unitRepositorio = new UnitRepositorio(application);
    }

    public void insertar(String nombre, String apodo, Uri imagenSeleccionada) {
        unitRepositorio.insertar(nombre, apodo,imagenSeleccionada);
    }

    public LiveData<List<Unit>> obtener() {
       return unitRepositorio.obtener();
    }

    void establecerImagenSeleccionada(Uri uri){
        imagenSeleccionada.setValue(uri);
    }
}

