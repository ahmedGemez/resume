package com.myexample.resume.Model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ModelDao {

    @Insert
    void insert(PersonalDataModel personalDataModel);

    @Query("SELECT * FROM PersonalDataModel")
    LiveData<List<PersonalDataModel>> getAllPersonalData();

    @Query("SELECT * FROM PersonalDataModel WHERE id=:id")
    LiveData<PersonalDataModel> getPersonalData(int id);

    @Update
    void update(PersonalDataModel personalDataModel);

    @Delete
    int delete(PersonalDataModel PersonalDataModel);
}
