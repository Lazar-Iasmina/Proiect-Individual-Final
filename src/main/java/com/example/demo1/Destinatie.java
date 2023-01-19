package com.example.demo1;

import java.io.Serializable;
import java.util.List;

public class Destinatie implements Serializable {
    private int id;
    private String nume;
    private String descriere;


    public Destinatie(String nume, String descriere,int id) {
        this.nume = nume;
        this.descriere=descriere;
        this.id=id;


    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
