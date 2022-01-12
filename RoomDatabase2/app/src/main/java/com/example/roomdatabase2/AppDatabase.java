package com.example.roomdatabase2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract  UserDao getUserDao();
}
