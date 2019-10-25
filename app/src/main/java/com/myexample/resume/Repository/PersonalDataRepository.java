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


    public LiveData<PersonalDataModel> getPersonalDataModel(int Id) {
        return modelDao.getPersonalData(Id);
    }

   public LiveData<List<PersonalDataModel>> getAllPersonalData() {
        return PersonalDataModel;
    }

    public void insert(PersonalDataModel PersonalData,int id) {
        new insertAsyncTask(modelDao,id).execute(PersonalData);
    }


    public void update(PersonalDataModel PersonalData,int id){
        new insertAsyncTask(modelDao,id).execute(PersonalData);

    }

    public void delete(PersonalDataModel PersonalData){
        new DeleteAsyncTask(modelDao).execute(PersonalData);

    }


    private static class insertAsyncTask extends AsyncTask<PersonalDataModel, Void, Void> {

        private ModelDao mAsyncTaskDao;
        private int id;

        insertAsyncTask(ModelDao dao,int id) {
            mAsyncTaskDao = dao;
            this.id=id;
        }

        @Override
        protected Void doInBackground(final PersonalDataModel... params) {
            if(id==0){
                mAsyncTaskDao.insert(params[0]);
            }else{
                mAsyncTaskDao.update(params[0]);
            }
            return null;
        }
    }


    private class DeleteAsyncTask extends  AsyncTask<PersonalDataModel, Void, Void> {

        private ModelDao mAsyncTaskDao;

        DeleteAsyncTask(ModelDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(PersonalDataModel... params) {
            Log.d("kjkjkj",params[0].getId()+"cscsc");
            mAsyncTaskDao.delete(params[0]);
            return null;
        }

    }



}
