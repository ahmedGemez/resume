package com.myexample.resume.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.myexample.resume.Model.ModelDao;
import com.myexample.resume.Model.PersonalDataModel;
import com.myexample.resume.Model.ResumeDataBase;

import java.util.List;

import androidx.lifecycle.LiveData;

public class PersonalDataRepository {

    private ModelDao modelDao;
    private LiveData<List<PersonalDataModel>> PersonalDataModel;


    public PersonalDataRepository(Application application){
        ResumeDataBase db = ResumeDataBase.getDatabase(application);
        modelDao= db.modelDao();
        PersonalDataModel = modelDao.getAllPersonalData();

    }

   public LiveData<List<PersonalDataModel>> getAllPersonalData() {
        return PersonalDataModel;
    }

    public void insert(PersonalDataModel PersonalData) {
        new insertAsyncTask(modelDao).execute(PersonalData);
    }


    private static class insertAsyncTask extends AsyncTask<PersonalDataModel, Void, Void> {

        private ModelDao mAsyncTaskDao;

        insertAsyncTask(ModelDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PersonalDataModel... params) {
            mAsyncTaskDao.insert(params[0]);
            Log.d("dlkncdn","inserted");
            return null;
        }
    }



}
