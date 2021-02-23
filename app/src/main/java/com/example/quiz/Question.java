package com.example.quiz;

public class Question {
    long id;
    int image;
    String Aanswer;
    String Banswer;
    String Canswer;
    String Danswer;
    String Correct;

    public Question(long id, int image, String aanswer, String banswer, String canswer, String danswer,String correct) {
        this.id = id;
        this.image = image;
        Aanswer = aanswer;
        Banswer = banswer;
        Canswer = canswer;
        Danswer = danswer;
        Correct=correct;
    }


    public String getCorrect() {
        return Correct;
    }

    public void setCorrect(String correct) {
        Correct = correct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAanswer() {
        return Aanswer;
    }

    public void setAanswer(String aanswer) {
        Aanswer = aanswer;
    }

    public String getBanswer() {
        return Banswer;
    }

    public void setBanswer(String banswer) {
        Banswer = banswer;
    }

    public String getCanswer() {
        return Canswer;
    }

    public void setCanswer(String canswer) {
        Canswer = canswer;
    }

    public String getDanswer() {
        return Danswer;
    }

    public void setDanswer(String danswer) {
        Danswer = danswer;
    }
}
