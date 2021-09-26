package com.example.sqlitecalismasi;

public class Kelimeler {
    private int kelime_id;
    private String turkce;
    private String ingilizce;


    public Kelimeler() {
    }

    public Kelimeler(int kelime_id, String turkce, String ingilizce) {
        this.kelime_id = kelime_id;
        this.turkce = turkce;
        this.ingilizce = ingilizce;

    }



    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }
    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        this.ingilizce = ingilizce;
    }
}
