package com.example.springinitializr.models;

public class Kompis {

    protected int id;
    protected String name;
    protected String address;
    protected String telefon;

    public Kompis(int id, String name, String address, String telefon) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
