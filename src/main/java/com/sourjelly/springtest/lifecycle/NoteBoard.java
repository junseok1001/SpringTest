package com.sourjelly.springtest.lifecycle;

public class NoteBoard {

    private String user;
    private String title;
    private String content;

    public NoteBoard(String user, String title, String content){
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public String getUser(){
        return user;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    @Override
    public String toString(){
        return "title : " + title + "user : " + user + " content : " + content;
    }
}
