package com.example.wireframes_407;

/**
 * construct different variable type.
 */

public class BottleList {
    private String usernameF; //The username of who create the bottle
    private String usernameR; // The username of who read the bottle
    private String date;
    private String gender;
    private String content;
    private Integer bottleID;


    public BottleList(String usernameF, String date, String gender, String usernameR,
                            int bottleID) {
        this.usernameF = usernameF;
        //this.content = content;
        this.date = date;
        this.gender = gender;
        //this.content = content;
        this.usernameR = usernameR;
        //this.usernameC = usernameC;
        this.bottleID = bottleID;
        //this.commentID = commentID;
    }


    public String getUsernameF() {
        return usernameF;
    }


    public String getUsernameR() {
        return usernameR;
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

