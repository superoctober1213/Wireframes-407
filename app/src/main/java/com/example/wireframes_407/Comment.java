package com.example.wireframes_407;
import java.sql.Timestamp;
public class Comment {
    private int bottleID;
    private Timestamp dateC;
    private int commentID;
    private String comment;
    private String genderC;
    private String usernameC;

    public Comment(int bottleID, Timestamp dateC, int commentID, String comment, String genderC, String usernameC) {
        this.bottleID = bottleID;
        this.dateC = dateC;
        this.commentID = commentID;
        this.comment = comment;
        this.genderC = genderC;
        this.usernameC = usernameC;
    }

    public int getBottleID(){return  bottleID;}

    public Timestamp getDateC(){return dateC;}

    public int getCommentID(){return commentID;}

    public String getComment() {return comment;}

    public String getGenderC() {return genderC;}

    public String getUsernameC() {return usernameC;}

}
