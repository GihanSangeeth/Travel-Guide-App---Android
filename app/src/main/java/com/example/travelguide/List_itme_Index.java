package com.example.travelguide;

public class List_itme_Index {
    private int id;
    private String Main_Title;
    private int page_id;
    private String Description;
    private  int Img;

    public List_itme_Index(int id, String main_Title, int page_id, String Description, int Img) {
        this.id = id;
        Main_Title = main_Title;
        this.page_id = page_id;
        this.Description = Description;
        this.Img =Img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain_Title() {
        return Main_Title;
    }

    public void setMain_Title(String main_Title) {
        Main_Title = main_Title;
    }

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public String getDescription(){

        return Description;
    }

    public void setDescription(String Description) {
        Description = Description;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int Img) {
        this.Img = Img;
    }

}



