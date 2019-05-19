package com.example.cardview_gridlayout2;

public class ViewModel {

    private long id;
    private String text;
    private String image;

    public ViewModel(long id, String text, String image){
        this.id = id;
        this.text = text;
        this.image = image;
    }
    public long getId(){
         return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public String setImage(String image){
        this.image = image;
    }

}
