package com.example.myapplication;

import android.app.Application;
import android.net.Uri;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UnitRepositorio {
    Executor executor = Executors.newSingleThreadExecutor();
    private final BaseDeDatos.UnitsDao unitsDao;

    public UnitRepositorio(Application application) {
        unitsDao = BaseDeDatos.getInstance(application).obtenerUnitsdao();
    }

    public void insertar(String nombre, String apodo, Uri imagenSeleccionada) {
        executor.execute(()->{
            unitsDao.insertar(new Unit(nombre,apodo,imagenSeleccionada.toString()));
        });

    }

}
