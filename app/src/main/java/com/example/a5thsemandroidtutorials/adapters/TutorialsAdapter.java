package com.example.a5thsemandroidtutorials.adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5thsemandroidtutorials.ItemClickListener;
import com.example.a5thsemandroidtutorials.R;
import com.example.a5thsemandroidtutorials.model.TutorialsData;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class TutorialsAdapter extends RecyclerView.Adapter<TutorialsAdapter.TutorialsViewHolder> {

    private Context context;
    private ArrayList<TutorialsData> list;
    ItemClickListener itemClickListener;
    int selectedPosition=-1;

    public TutorialsAdapter(Context context, ArrayList<TutorialsData> list, ItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener=itemClickListener;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get adapter position
                int position=holder.getAdapterPosition();
                // call listener
                itemClickListener.onClick(position,list.get(position));
                // update position
                selectedPosition=position;
                // notify
                notifyDataSetChanged();
            }
        });


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
