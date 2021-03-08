package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Unit {
    @PrimaryKey(autoGenerate = true)
     int id;
    String nombre;
    String apodo;
    String fotoUnit;

    public Unit(String nombre, String apodo, String fotoUnit) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fotoUnit = fotoUnit;
    }

}
