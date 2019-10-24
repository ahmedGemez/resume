package com.myexample.resume.Model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {PersonalDataModel.class}, version = 1)
public abstract class ResumeDataBase extends RoomDatabase {

    public abstract ModelDao modelDao ();

    private static volatile ResumeDataBase resumeDataBaseInstance;

    public static ResumeDataBase getDatabase(final Context context) {
        if (resumeDataBaseInstance == null) {
            synchronized (ResumeDataBase.class) {
                if (resumeDataBaseInstance == null) {
                    resumeDataBaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                            ResumeDataBase.class, "ResumeDataBase")
                            .build();
                }
            }
        }
        return resumeDataBaseInstance;
    }


}
