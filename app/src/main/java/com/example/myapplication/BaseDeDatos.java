package com.example.myapplication;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Unit.class}, version = 1, exportSchema = false)
public  abstract class BaseDeDatos extends RoomDatabase {

        private static volatile BaseDeDatos db;

        public abstract UnitsDao obtenerUnitsdao();

        public static BaseDeDatos getInstance(final Context context){
            if(db == null){
                synchronized (BaseDeDatos.class){
                    if(db == null){
                        db = Room.databaseBuilder(context, BaseDeDatos.class, "app.db")
                                .fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
            return db;
        }

        @Dao
    interface UnitsDao{
            @Insert
            void insertar(Unit unit);
        }

}
