package com.example.roomdatabase2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "stud")
public class Student{
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "fname")
    public String name;
}
