package com.sajib.infotaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sajib.infotaker.Database.AppDatabase;
import com.sajib.infotaker.Database.SurveyResponseDao;
import com.sajib.infotaker.Database.SurveyResponseDataModel;
import com.sajib.infotaker.Database.SurveyResponseEntity;
import com.sajib.infotaker.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String question101 = "null";
    private String question102 = "null";
    private String question103 = "null";
    private String question104 = "null";
    private String question105Name = "null";
    private String question105Designation = "null";
    private String question105Union = "null";
    private String question105subblock = "null";
    private String question106 = "null";
    private String question107name = "null";
    private String question108phone = "null";
    private String question109DoB = "null";
    private int userid = 101;
    private RadioGroup radioGroupQ101, radioGroupQ102, radioGroupQ103, radioGroupQ104;
    private RadioButton selectedRadioButtonQ101, selectedRadioButtonQ102, selectedRadioButtonQ103, selectedRadioButtonQ104;
    private EditText name105, designation105, union105, subblock105, noreason106, name107, phone108, dob109;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        radioGroupQ101 = binding.radioGroupQ101;
        radioGroupQ102 = binding.radioGroupQ102;
        radioGroupQ103 = binding.radioGroupQ103;
        radioGroupQ104 = binding.radioGroupQ104;

        name105 = findViewById(R.id.name105id);
        designation105 = findViewById(R.id.designation105id);
        union105 = findViewById(R.id.union105id);
        subblock105 = findViewById(R.id.subblock105id);
        noreason106 = findViewById(R.id.Noreason106id);

        name107 = findViewById(R.id.name107id);
        phone108 = findViewById(R.id.phone108id);
        dob109 = findViewById(R.id.dob109id);


        Button submitButton = findViewById(R.id.submitbtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get selected radio button for Q101
                int selectedRadioButtonIdQ101 = radioGroupQ101.getCheckedRadioButtonId();

                selectedRadioButtonQ101 = findViewById(selectedRadioButtonIdQ101);
                question101 = selectedRadioButtonQ101.getText().toString();


// Get selected radio button for Q102
                int selectedRadioButtonIdQ102 = radioGroupQ102.getCheckedRadioButtonId();

                selectedRadioButtonQ102 = findViewById(selectedRadioButtonIdQ102);


// Get selected radio button for Q103
                int selectedRadioButtonIdQ103 = radioGroupQ103.getCheckedRadioButtonId();

                selectedRadioButtonQ103 = findViewById(selectedRadioButtonIdQ103);
                question103 = selectedRadioButtonQ103.getText().toString();


// Get selected radio button for Q104
                int selectedRadioButtonIdQ104 = radioGroupQ104.getCheckedRadioButtonId();

                selectedRadioButtonQ104 = findViewById(selectedRadioButtonIdQ104);
                question104 = selectedRadioButtonQ104.getText().toString();


                question105Name = name105.getText().toString().trim();
                question105Designation = designation105.getText().toString().trim();
                question105Union = union105.getText().toString().trim();
                question105subblock = subblock105.getText().toString().trim();
                question106 = noreason106.getText().toString().trim();
                question107name = name107.getText().toString().trim();
                question108phone = phone108.getText().toString().trim();
                question109DoB = dob109.getText().toString().trim();


                // Insert the survey response into the database

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "survey_database").allowMainThreadQueries() // For simplicity, consider using AsyncTask or RxJava for database operations on the main thread.
                        .build();
                saveToDatabase();

                // Intent intent = new Intent(MainActivity.this, UserActivity.class);
                //startActivity(intent);
            }
        });


    }

    private void saveToDatabase() {
        SurveyResponseEntity surveyResponse = new SurveyResponseEntity();
        surveyResponse.question101 = question101;
        surveyResponse.question102 = question102;
        surveyResponse.question103 = question103;
        surveyResponse.question104 = question104;
        surveyResponse.question105Name = question105Name;
        surveyResponse.question105Designation = question105Designation;
        surveyResponse.question105Union = question105Union;
        surveyResponse.question105subblock = question105subblock;
        surveyResponse.question106 = question106;
        surveyResponse.question107name = question107name;
        surveyResponse.question108phone = question108phone;
        surveyResponse.question109DoB = question109DoB;


        appDatabase.surveyResponseDao().insertSurveyResponse(surveyResponse);

        Toast.makeText(this, "Data saved to database", Toast.LENGTH_SHORT).show();
    }

    public void YesBtnclicked(View view) {
        binding.question104id.setVisibility(View.VISIBLE);
        binding.question105cardid.setVisibility(View.VISIBLE);
        binding.question106cardid.setVisibility(View.GONE);
        binding.question107cardid.setVisibility(View.GONE);
    }

    public void NoBtnclicked(View view) {
        binding.question104id.setVisibility(View.GONE);
        binding.question105cardid.setVisibility(View.GONE);
        binding.question106cardid.setVisibility(View.VISIBLE);
        binding.question107cardid.setVisibility(View.VISIBLE);
    }
}