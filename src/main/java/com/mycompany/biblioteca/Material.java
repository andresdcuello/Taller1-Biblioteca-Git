package com.mycompany.biblioteca;

public class Material {
    protected String code;
    protected String title;
    protected int publicationYear;

    public Material(String code, String title, int publicationYear) {
        this.code = code;
        this.title = title;
        this.publicationYear = publicationYear;
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Title: " + title + ", Year: " + publicationYear;
    }
}