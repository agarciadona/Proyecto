package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class UnitListRepositorio {

    List<UnitList> UnitLists = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<UnitList> UnitLists);
    }

    UnitListRepositorio(){
        UnitLists.add(new UnitList("abelbanner.png"));
       }

    List<UnitList> obtener() {
        return UnitLists;
    }

    void insertar(UnitList UnitList, Callback callback){
        UnitLists.add(UnitList);
        callback.cuandoFinalice(UnitLists);
    }

    void eliminar(UnitList UnitList, Callback callback) {
        UnitLists.remove(UnitList);
        callback.cuandoFinalice(UnitLists);
    }

    void actualizar(UnitList UnitList, float valoracion, Callback callback) {
        UnitList.valoracion = valoracion;
        callback.cuandoFinalice(UnitLists);
    }
}