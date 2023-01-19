package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;

public class ZboruriRezervate  extends Zbor implements Serializable {
    private String user;


    public ZboruriRezervate(String user, String plecare, String sosire, LocalDate timp,String ora,int pret) {
        super(plecare,sosire,timp,ora,pret);
        this.user = user;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ZboruriRezervate{" +
                "user='" + user + '\'' +
                '}'+ this.getaSosire();
    }
}
