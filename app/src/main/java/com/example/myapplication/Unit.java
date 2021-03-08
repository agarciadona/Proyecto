package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Unit {
    @PrimaryKey(autoGenerate = true)
     int id;

    String nombre;
    String apodo;
    String foto;

    public Unit(String nombre, String apodo, String foto) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.foto = foto;
    }

}
