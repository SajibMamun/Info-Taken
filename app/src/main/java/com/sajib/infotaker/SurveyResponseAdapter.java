package com.sajib.infotaker;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sajib.infotaker.Database.SurveyResponseDataModel;
import com.sajib.infotaker.Database.SurveyResponseEntity;


import java.util.List;

public class SurveyResponseAdapter extends RecyclerView.Adapter<SurveyResponseAdapter.ViewHolder> {

    private List<SurveyResponseDataModel> surveyResponses;

    public SurveyResponseAdapter(List<SurveyResponseDataModel> surveyResponses) {
        this.surveyResponses = surveyResponses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdesign, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SurveyResponseDataModel surveyResponse = surveyResponses.get(position);

        // Set data to the TextViews or other UI elements in the item layout
        holder.itemName105.setText(surveyResponse.question105Name);
        holder.itemDesignation105.setText(surveyResponse.question105Designation);
        holder.itemUnion105.setText(surveyResponse.question105Union);
        holder.itemSubblock105.setText(surveyResponse.question105subblock);
        holder.question101ans.setText(surveyResponse.question101);
        holder.question102ans.setText(surveyResponse.question102);
        holder.question103ans.setText(surveyResponse.question103);
        holder.question104ans.setText(surveyResponse.question104);
        holder.itemDName107.setText(surveyResponse.question107name);
        holder.itemPhone108.setText(surveyResponse.question108phone);
        holder.itemDob109.setText(surveyResponse.question109DoB);
        holder.reasonId.setText(surveyResponse.question106);
    }

    @Override
    public int getItemCount() {
        return surveyResponses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName105, itemDesignation105, itemUnion105, itemSubblock105,
                question101ans, question102ans, question103ans, question104ans,
                itemDName107, itemPhone108, itemDob109, reasonId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize your TextViews
            itemName105 = itemView.findViewById(R.id.itemname105id);
            itemDesignation105 = itemView.findViewById(R.id.itemdesignation105id);
            itemUnion105 = itemView.findViewById(R.id.itemunion105id);
            itemSubblock105 = itemView.findViewById(R.id.itemsubblock105id);
            question101ans = itemView.findViewById(R.id.question101ansid);
            question102ans = itemView.findViewById(R.id.question102ansid);
            question103ans = itemView.findViewById(R.id.question103ansid);
            question104ans = itemView.findViewById(R.id.question104ansid);
            itemDName107 = itemView.findViewById(R.id.itemdname107id);
            itemPhone108 = itemView.findViewById(R.id.itemphone108id);
            itemDob109 = itemView.findViewById(R.id.itemdob109id);
            reasonId = itemView.findViewById(R.id.reasonid);
        }
    }
}