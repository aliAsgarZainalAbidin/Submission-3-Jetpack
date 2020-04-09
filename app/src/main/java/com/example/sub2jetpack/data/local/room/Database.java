package com.example.sub2jetpack.data.local.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;

@androidx.room.Database(entities = {MovieEntity.class, TvEntity.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract DataDao dataDao();

    private static volatile Database INSTANCE;

    public static Database getInstance(Context context){
        if (INSTANCE==null){
            synchronized (Database.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "katalog.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
