package com.example.wireframes_407;

import java.sql.Timestamp;

public class Readhistory {
    private String usernameR;
    private int bottleID;
    private Timestamp time;

    public Readhistory(String usernameR, int bottleID, Timestamp time) {
        this.usernameR = usernameR; //The username of user who read this bottle
        this.bottleID = bottleID; //Define the bottle
        this.time = time; //The time that the user read(Sort)
    }

    public String getUsernameR() {return usernameR;}

    public int getBottleID() {return bottleID;}

    public Timestamp getTime() {return time;}
}
