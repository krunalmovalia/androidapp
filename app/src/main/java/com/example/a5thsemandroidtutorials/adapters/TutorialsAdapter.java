package com.example.a5thsemandroidtutorials.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5thsemandroidtutorials.R;
import com.example.a5thsemandroidtutorials.model.TutorialsData;

import java.util.ArrayList;


public class TutorialsAdapter extends RecyclerView.Adapter<TutorialsAdapter.TutorialsViewHolder> {

    private Context context;
    private ArrayList<TutorialsData> list;

    public TutorialsAdapter(Context context, ArrayList<TutorialsData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TutorialsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_list,parent,false);
        return new TutorialsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorialsViewHolder holder, int position) {
        holder.txtTutorial.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TutorialsViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtTutorial;

        public TutorialsViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTutorial = itemView.findViewById(R.id.txt_tutorial);

        }
    }
}
