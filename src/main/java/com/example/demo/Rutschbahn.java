package com.example.demo;

public class Rutschbahn extends PedaloDecorator{

    double preis = 5;

    public Rutschbahn(Pedalo pedalo) {
        super(pedalo);
    }

    public String decorate(){
        return super.decorate() + plusRutschbahn();
    }

    public String plusRutschbahn(){
        return " mit Rutschbahn";
    }

    public double price(){return super.price() + preisRutschbahn();}

    public double preisRutschbahn(){
        return preis;
    }
}
