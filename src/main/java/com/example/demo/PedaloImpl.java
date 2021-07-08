package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "Pedalo")
public class PedaloImpl implements Pedalo{
    @Id
    @GeneratedValue
    private Long id;
    private int plaetze;
    private String beschreibung;
    private double preis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlaetze() {
        return plaetze;
    }

    public void setPlaetze(int plaetze) {
        this.plaetze = plaetze;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }


    @Override
    public String decorate() {
        return "Pedalo";
    }

    @Override
    public double price() {
        return preis;
    }

}