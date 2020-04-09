package com.example.wireframes_407;

public class HistoryList {

    private String usernameF; //The username of who create the bottle
    private String date;
    private String gender;
    private String content;
    private String usernameC; // The username of who comment the bottle
    private int bottleID;

    public HistoryList(String usernameF, String date, String gender, String content, String usernameC,
                       int bottleID) {
        this.usernameF = usernameF;
        this.content = content;
        this.date = date;
        this.gender = gender;
        this.usernameC = usernameC;
        this.bottleID = bottleID;
    }


    public String getUsernameF() {
        return usernameF;
    }

    public String getUsernameC() {
        return usernameC;
    }

    public String getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    public String getContent() {
        return content;
    }

    public int getBottleID() {
        return bottleID;
    }

}


