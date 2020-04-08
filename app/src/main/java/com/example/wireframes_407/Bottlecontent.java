package com.example.wireframes_407;

public class Bottlecontent {
    private String usernameF; //The username of who create the bottle
    private String usernameR; // The username of who read the bottle
    private String date;
    private String gender;
    private String content;
    private String usernameC; // The username of who comment the bottle


    public Bottlecontent(String usernameF, String usernameR, String date, String gender, String content, String usernameC) {
        this.usernameF = usernameF;
        this.content = content;
        this.date = date;
        this.gender = gender;
        this.content = content;
        this.usernameR = usernameR;
        this.usernameC = usernameC;
    }

    public String getUsernameF() {
        return usernameF;
    }

    public String getUsernameC() {
        return usernameC;
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
}
