package com.example.wireframes_407;

import java.sql.Timestamp;

public class Readhistory {
    private String usernameR;
    private int bottleID;
    private Timestamp time;

    public Readhistory(String usernameR, int bottleID, Timestamp time) {
        this.usernameR = usernameR;
        this.bottleID = bottleID;
        this.time = time;
    }

    public String getUsernameR() {return usernameR;}

    public int getBottleID() {return bottleID;}

    public Timestamp getTime() {return time;}
}
