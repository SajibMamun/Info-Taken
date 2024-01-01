package com.sajib.infotaker;

import static kotlinx.coroutines.BuildersKt.withContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.sajib.infotaker.Database.AppDatabase;
import com.sajib.infotaker.Database.SurveyResponseDataModel;
import com.sajib.infotaker.Database.SurveyResponseEntity;
import com.sajib.infotaker.databinding.ActivityMainBinding;
import com.sajib.infotaker.databinding.ActivityUserBinding;

import java.util.List;

import java.util.List;

public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;
    private AppDatabase appDatabase;
    private RecyclerView recyclerView;
    private SurveyResponseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appDatabase = AppDatabase.getInstance(this);
        recyclerView = binding.recyclerviewid;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        List<SurveyResponseDataModel> surveyResponses = appDatabase.surveyResponseDao().getAllSurveyResponses();
        adapter = new SurveyResponseAdapter(surveyResponses);
        recyclerView.setAdapter(adapter);
    }
}