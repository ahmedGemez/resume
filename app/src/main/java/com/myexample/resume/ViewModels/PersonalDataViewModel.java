package com.myexample.resume.ViewModels;

import android.app.Application;

import com.myexample.resume.Model.PersonalDataModel;
import com.myexample.resume.Repository.PersonalDataRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PersonalDataViewModel extends AndroidViewModel {

    private PersonalDataRepository personalDataRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<PersonalDataModel>> PersonalDataModel;


    public PersonalDataViewModel(@NonNull Application application) {
        super(application);
        personalDataRepository = new PersonalDataRepository(application);
        PersonalDataModel = personalDataRepository.getAllPersonalData();
    }

    public void insert(PersonalDataModel personalDataModel) {
        personalDataRepository.insert(personalDataModel);
    }


    public LiveData<List<PersonalDataModel>> getAllPersonalData() {
        return PersonalDataModel;
    }
}
