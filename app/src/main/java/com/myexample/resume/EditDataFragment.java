package com.myexample.resume;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myexample.resume.Model.PersonalDataModel;
import com.myexample.resume.ViewModels.PersonalDataViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditDataFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private PersonalDataViewModel  personalDataViewModel;

    private OnFragmentInteractionListener mListener;

    public EditDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditDataFragment newInstance(String param1, String param2) {
        EditDataFragment fragment = new EditDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        personalDataViewModel = ViewModelProviders.of(this).get(PersonalDataViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_data, container, false);final EditText Ename=view.findViewById(R.id.Ename_id);
        final EditText Eaddress=view.findViewById(R.id.Eaddress_id);
        final EditText Ephone=view.findViewById(R.id.Ephone_id);
        final EditText Eemail=view.findViewById(R.id.Eemail_id);
        final EditText Ecareer=view.findViewById(R.id.Ecareer);

        Button SaveButton=view.findViewById(R.id.save);

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final PersonalDataModel personalDataModel= new PersonalDataModel( Ename.getText().toString(),Eemail.getText().toString(),Eaddress.getText().toString(),Ephone.getText().toString(),Ecareer.getText().toString());

                Log.d("chchfcfh",Ename.getText().toString()+"ccvvf");
                Log.d("ahmed",personalDataModel.name+"ccvvf");

                personalDataViewModel.insert(personalDataModel);
            }
        });


         return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
