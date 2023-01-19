package com.example.demo1;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private String username;
    private String parola;
    private int id;

    public User(String username, String parola, int id) {
        this.username = username;
        this.parola = parola;
        this.id = id;
    }
    /*public User(){

    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
