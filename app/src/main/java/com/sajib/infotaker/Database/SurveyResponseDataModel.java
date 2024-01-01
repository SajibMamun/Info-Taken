package com.sajib.infotaker.Database;

public class SurveyResponseDataModel {
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

    public SurveyResponseDataModel(int id, String question101, String question102, String question103,
                                   String question104, String question105Name, String question105Designation,
                                   String question105Union, String question105subblock, String question106,
                                   String question107name, String question108phone, String question109DoB) {
        this.id = id;
        this.question101 = question101;
        this.question102 = question102;
        this.question103 = question103;
        this.question104 = question104;
        this.question105Name = question105Name;
        this.question105Designation = question105Designation;
        this.question105Union = question105Union;
        this.question105subblock = question105subblock;
        this.question106 = question106;
        this.question107name = question107name;
        this.question108phone = question108phone;
        this.question109DoB = question109DoB;
    }
}