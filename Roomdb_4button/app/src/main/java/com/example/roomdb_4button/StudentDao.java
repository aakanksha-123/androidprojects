package com.example.roomdb_4button;

import android.util.Log;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    // @Insert
    // void insertStudent(Student st);
    //@Insert
    // void insertStudent(Student s1, Student s2);
   @Insert
    void addAll(Student... st);


    // @Update
    // void updateStudent(Student st);
    //@Insert
    // void updateStudent(Student s1, Student s2);
   @Update
    void updateAll(Student... st);

    // @Delete
    // void deleteStudent(Student st);
    //@Insert
    // void deleteStudent(Student s1, Student s2);
    @Delete
    void deleteAll(Student... st);

    //@Query("select * from stud")
    //Student[] getAll();


   // @Query("select * from stud")
   // List<Student> getAllStudent();
   @Query("select * from stud")
   List<Student> getAllStudent();

    @Query("select * from stud where id=:sid")
    Student getStudent(int sid);


   // Student st= StudentDao(int id);
   // Student st = StudentDao.getStudent(2);

   // Log.i("id",st.getId());
  //  Log.i("id",st.getName());


//    List<Student> list1 = StudentDao.getAllStudent();
//    for(Student st : list1){
//        Log.i("id",st.getId()) ;
//        Log.i("name",st.getname());
//    }

}
