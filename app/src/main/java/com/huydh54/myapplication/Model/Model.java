package com.huydh54.myapplication.Model;

public class Model {
    private String code;
    private String title;
    private String image;
    private String detail;


    public Model(){}

    public Model(String title) {
        this.title = title;
    }

    public Model(String title, String image, String detail) {
        this.title = title;
        this.image = image;
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
