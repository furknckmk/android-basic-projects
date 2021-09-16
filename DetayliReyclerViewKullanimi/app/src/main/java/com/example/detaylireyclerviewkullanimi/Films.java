package com.example.detaylireyclerviewkullanimi;

public class Films {
    private int film_id;
    private String film_name;
    private String film_Image_name;
    private Double film_price;

    public Films() {
    }

    public Films(int film_id, String film_name, String film_Image_name, Double film_price) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.film_Image_name = film_Image_name;
        this.film_price = film_price;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_Image_name() {
        return film_Image_name;
    }

    public void setFilm_Image_name(String film_Image_name) {
        this.film_Image_name = film_Image_name;
    }

    public Double getFilm_price() {
        return film_price;
    }

    public void setFilm_price(Double film_price) {
        this.film_price = film_price;
    }
}
