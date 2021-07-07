package com.example.demo;

public class Sonnenschirm extends PedaloDecorator{

    double preis = 2.5;

    public Sonnenschirm(Pedalo pedalo){
        super(pedalo);
    }

    public String decorate(){
        return super.decorate() + plusSonnenschirm();
    }

    public double price(){return super.price() + preisSonnenschirm();}

    public String plusSonnenschirm(){
        return " mit Sonnenschirm";
    }

    public double preisSonnenschirm(){
        return preis;
    };
}
