
package com.example.demo1;
import java.time.LocalDate;

public class Zbor1 {
    private int idZbor;
    private String aeroportPlecare;
    private String aeroportSosire;
    private String dataPlecare;
    private String dataSosire;
    private String oraPlecare;
    private String oraSosire;
    private int pret;
    private String companie;

    public Zbor1() {
    }

    public Zbor1(int idZbor, String aeroportPlecare, String aeroportSosire, String dataPlecare, String dataSosire, String oraPlecare, String oraSosire, int pret, String companie) {
        this.idZbor = idZbor;
        this.aeroportPlecare = aeroportPlecare;
        this.aeroportSosire = aeroportSosire;
        this.dataPlecare = dataPlecare;
        this.dataSosire = dataSosire;
        this.oraPlecare = oraPlecare;
        this.oraSosire = oraSosire;
        this.pret = pret;
        this.companie = companie;
    }

    public int getIdZbor() {
        return idZbor;
    }

    public void setIdZbor(int idZbor) {
        this.idZbor = idZbor;
    }

    public String getAeroportPlecare() {
        return aeroportPlecare;
    }

    public void setAeroportPlecare(String aeroportPlecare) {
        this.aeroportPlecare = aeroportPlecare;
    }

    public String getAeroportSosire() {
        return aeroportSosire;
    }

    public void setAeroportSosire(String aeroportSosire) {
        this.aeroportSosire = aeroportSosire;
    }

    public String getDataPlecare() {
        return dataPlecare;
    }

    public void setDataPlecare(String dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public String getDataSosire() {
        return dataSosire;
    }

    public void setDataSosire(String dataSosire) {
        this.dataSosire = dataSosire;
    }

    public String getOraPlecare() {
        return oraPlecare;
    }

    public void setOraPlecare(String oraPlecare) {
        this.oraPlecare = oraPlecare;
    }

    public String getOraSosire() {
        return oraSosire;
    }

    public void setOraSosire(String oraSosire) {
        this.oraSosire = oraSosire;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    @Override
    public String toString() {
        return "Zbor1{" +
                "idZbor=" + idZbor +
                ", aeroportPlecare='" + aeroportPlecare + '\'' +
                ", aeroportSosire='" + aeroportSosire + '\'' +
                ", dataPlecare=" + dataPlecare +
                ", dataSosire=" + dataSosire +
                ", oraPlecare='" + oraPlecare + '\'' +
                ", oraSosire='" + oraSosire + '\'' +
                ", pret=" + pret +
                ", companie='" + companie + '\'' +
                '}';
    }
}