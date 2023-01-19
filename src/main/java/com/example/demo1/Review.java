package com.example.demo1;

public class Review {
    private int idRev;
    private String nume;
    private String mesaj;
    private int nrStele;

    public Review() {
    }

    public Review(int idRev, String nume, String mesaj, int nrStele) {
        this.idRev = idRev;
        this.nume = nume;
        this.mesaj = mesaj;
        this.nrStele = nrStele;
    }

    public int getIdRev() {
        return idRev;
    }

    public void setIdRev(int idRev) {
        this.idRev = idRev;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public int getNrStele() {
        return nrStele;
    }

    public void setNrStele(int nrStele) {
        this.nrStele = nrStele;
    }

}
