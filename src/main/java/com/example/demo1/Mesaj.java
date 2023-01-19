package com.example.demo1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mesaj  implements Serializable {
    private String user;
    private String zbor;
    private List<String> listaMesaje =new ArrayList<>();

    public Mesaj(String user, String zbor, List<String> listaMesaje) {
        this.user = user;
        this.zbor = zbor;
        this.listaMesaje = listaMesaje;
    }

    public Mesaj() {
    }

    public Mesaj(String user, String zbor) {
        this.user = user;
        this.zbor = zbor;
    }


    public Mesaj(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getZbor() {
        return zbor;
    }

    public void setZbor(String zbor) {
        this.zbor = zbor;
    }

    public List<String> getListaMesaje() {
        return listaMesaje;
    }

    public void setListaMesaje(List<String> listaMesaje) {
        this.listaMesaje = listaMesaje;
    }

    @Override
    public String toString() {
        return "Mesaj{" +
                "user='" + user + '\'' +
                ", zbor='" + zbor + '\'' +
                ", listaMesaje=" + listaMesaje +
                '}';
    }
}
