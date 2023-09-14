package com.example.primeravance;

public class Item {
    private int image;
    private String tittle;

    public Item(int image, String tittle) {

        this.image = image;
        this.tittle = tittle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
