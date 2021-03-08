package com.example.myapplication;

import android.app.Application;
import android.net.Uri;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UnitRepositorio {

    Executor executor = Executors.newSingleThreadExecutor();
    BaseDeDatos.UnitsDao unitsDao;

    public UnitRepositorio(Application application) {
        unitsDao = BaseDeDatos.getInstance(application).obtenerUnitsdao();
    }

    void insertar(String nombre, String apodo, Uri imagenSeleccionada) {
            executor.execute(()-> unitsDao.insertar(new Unit(nombre,apodo,imagenSeleccionada.toString())));
    }

    public LiveData<List<Unit>> obtener() {
        return unitsDao.obtener();
    }
}
