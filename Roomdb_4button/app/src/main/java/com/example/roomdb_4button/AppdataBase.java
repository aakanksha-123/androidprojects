package com.example.roomdb_4button;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)

abstract public class AppdataBase extends RoomDatabase {
    public abstract  StudentDao StudentDao();
}
