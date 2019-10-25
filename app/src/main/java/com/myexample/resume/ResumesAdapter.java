package com.myexample.resume;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myexample.resume.Model.PersonalDataModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class ResumesAdapter extends RecyclerView.Adapter<ResumesAdapter.ResumeViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<PersonalDataModel> personalDataModels;
    private OnItemClickListener onItemClickListener;

    ResumesAdapter(Context context,OnItemClickListener onItemClickListener){
        this.layoutInflater=LayoutInflater.from(context);
        this.onItemClickListener=onItemClickListener;
        mContext=context;
    }


    @NonNull
    @Override
    public ResumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        ResumeViewHolder viewHolder = new ResumeViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeViewHolder holder, int position) {

        if (personalDataModels != null) {
            final PersonalDataModel personalDataModel = personalDataModels.get(position);
            Log.d("kjhcd",personalDataModel.getEmail()+"dddk");
            holder.setData(personalDataModel.getName(),personalDataModel.getId()+"", position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(personalDataModel.getId(),view);
                }
            });

            holder.setListeners(personalDataModel.getId());



        } else {
            // Covers the case of data not being ready yet.
            holder.name.setText(R.string.no_Name);
        }

    }

    @Override
    public int getItemCount() {
        if (personalDataModels != null)
            return personalDataModels.size();
        else return 0;
    }

    public void setPersonalDataModel(List<PersonalDataModel> personalDataModels) {
        this.personalDataModels = personalDataModels;
        Log.d("jddncnd",personalDataModels+"dmcnc");
        notifyDataSetChanged();
    }

    class ResumeViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView id;
        private int mPosition;
        View itemView;
        ImageView edit;
        ImageView delete;
        public ResumeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            name=itemView.findViewById(R.id.txname);
            id=itemView.findViewById(R.id.txid);
            edit=itemView.findViewById(R.id.ivRowEdit);
            delete=itemView.findViewById(R.id.ivRowDelete);
        }

        public void setData(String name,String id, int position) {
            this.name.setText(name);
            this.id.setText(id);
            mPosition = position;
        }

        public void setListeners(final int id){
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle=new Bundle();
                    bundle.putInt("id",id);
                    Navigation.findNavController(view).navigate(R.id.editDataFragment, bundle);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onItemClickListener.onItemDeleteClick(personalDataModels.get(mPosition));

                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id,View view);
        void onItemDeleteClick(PersonalDataModel personalDataModel);
    }

}
