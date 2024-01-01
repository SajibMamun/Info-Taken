package com.sajib.infotaker.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SurveyResponseDao {

    @Insert
    void insertSurveyResponse(SurveyResponseEntity surveyResponse);

    @Query("SELECT * FROM survey_responses")
    List<SurveyResponseDataModel> getAllSurveyResponses();
}