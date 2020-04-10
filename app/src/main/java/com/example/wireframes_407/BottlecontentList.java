package com.example.wireframes_407;

/**
 * This file is use to
 */
public class BottlecontentList {

    private String usernameF; //The username of who create the bottle
    private String date; // The date create bottle and comment
    private String gender; // The gender of the user
    private String content; // The context write by the first owner of the bottle
    private String usernameC; // The username of who comment the bottle
    private int bottleID;

    public BottlecontentList(String usernameF, String date, String gender, String content, String usernameC,
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


