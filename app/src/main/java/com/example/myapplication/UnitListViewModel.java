package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UnitListViewModel extends AndroidViewModel{

    UnitListRepositorio unitsListRepositorio;

    MutableLiveData<List<UnitList>> listUnitsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<UnitList> elementoSeleccionado = new MutableLiveData<>();

    public UnitListViewModel(@NonNull Application application) {
        super(application);

        unitsListRepositorio = new UnitListRepositorio();

        listUnitsMutableLiveData.setValue(unitsListRepositorio.obtener());
    }

    MutableLiveData<List<UnitList>> obtener(){
        return listUnitsMutableLiveData;
    }

    void insertar(UnitList elemento){
        unitsListRepositorio.insertar(elemento, new UnitListRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<UnitList> elementos) {
                listUnitsMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(UnitList elemento){
        unitsListRepositorio.eliminar(elemento, new UnitListRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<UnitList> elementos) {
                listUnitsMutableLiveData.setValue(elementos);
            }
        });
    }

    void actualizar(UnitList elemento, float valoracion){
        unitsListRepositorio.actualizar(elemento, valoracion, new UnitListRepositorio.Callback(){
            @Override
            public void cuandoFinalice(List<UnitList> elementos) {
                listUnitsMutableLiveData.setValue(elementos);
            }
        });
    }

    void seleccionar(UnitList units){
        elementoSeleccionado.setValue(units);
    }

    MutableLiveData<UnitList> seleccionado(){
        return elementoSeleccionado;
    }

}

