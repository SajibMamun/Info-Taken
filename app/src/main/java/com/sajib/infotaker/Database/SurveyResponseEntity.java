package com.sajib.infotaker.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "survey_responses")
public class SurveyResponseEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;


    public String question101;

    public String question102;

    public String question103;

    public String question104;

    public String question105Name;


    public String question105Designation;


    public String question105Union;

    public String question105subblock;


    public String question106;


    public String question107name;


    public String question108phone;

    public String question109DoB;
}