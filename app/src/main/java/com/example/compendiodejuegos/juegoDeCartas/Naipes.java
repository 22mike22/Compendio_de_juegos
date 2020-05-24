package com.example.compendiodejuegos.juegoDeCartas;

import java.util.ArrayList;

public class Naipes extends baraja{
    public Naipes(int numDeBarajas){
        super(numDeBarajas);
        cartas=new ArrayList();
        //del 0 al 12 son las cartas de picas del 13 al 25 son las de trebol
        //del 26 al 38 las de diamante y las de 39 al 51 corazon
        for(int i=0;i<13*4;i++){
            cartas.add(i);
        }
        resetear_baraja();
    }
}
