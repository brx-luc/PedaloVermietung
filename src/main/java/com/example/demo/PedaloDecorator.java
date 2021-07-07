package com.example.demo;

public abstract class PedaloDecorator implements Pedalo{
    private Pedalo pedalo;

    public PedaloDecorator(Pedalo pedalo) {
        this.pedalo = pedalo;
    }

    @Override
    public String decorate(){
        return pedalo.decorate();
    }

    @Override
    public double price(){
        return pedalo.price();
    }
}
