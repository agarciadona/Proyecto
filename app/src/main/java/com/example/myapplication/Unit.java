package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Unit {
    @PrimaryKey(autoGenerate = true)
     int id;

    String nombre;
    String apodo;
    String portada;

    public Unit(String nombre, String apodo, String portada) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.portada = portada;
    }

}
