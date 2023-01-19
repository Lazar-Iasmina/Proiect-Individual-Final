package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;

public class Zbor implements Serializable {
   // private static long serialVersionUID=6372658316597595304;
    private String aPlecare;
    private String aSosire;
    private LocalDate dataPlecare;
    private String oraZbor;
    private int pretZbor;

    public Zbor(String aPlecare, String aSosire, LocalDate dataPlecare, String oraZbor,int pret) {
        this.aPlecare = aPlecare;
        this.aSosire = aSosire;
        this.dataPlecare = dataPlecare;
        this.oraZbor = oraZbor;
        this.pretZbor=pret;
    }


    public String getaPlecare() {
        return aPlecare;
    }

    public void setaPlecare(String aPlecare) {
        this.aPlecare = aPlecare;
    }

    public String getaSosire() {
        return aSosire;
    }

    public void setaSosire(String aSosire) {
        this.aSosire = aSosire;
    }

    public LocalDate getDataPlecare() {
        return dataPlecare;
    }

    public void setDataPlecare(LocalDate dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public String getOraZbor() {
        return oraZbor;
    }

    public void setOraZbor(String oraZbor) {
        this.oraZbor = oraZbor;
    }

    public int getPretZbor() {
        return pretZbor;
    }

    public void setPretZbor(int pretZbor) {
        this.pretZbor = pretZbor;
    }


}
