package com.example.lol_deliver;

public class Personal {
    private int img;
    private String subject;
    private String content;
    public Personal(int img, String subject, String content){
        this.img = img;
        this.subject = subject;
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
