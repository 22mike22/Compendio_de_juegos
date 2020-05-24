package com.example.compendiodejuegos.juegoDeCartas;

import java.util.ArrayList;

public class jugador {
    public ArrayList mano;
    public String nombre;
    //0 o null a la vista de todos, 1 solo se ve para el jugador, 2 ocultos para todos, 3 oculto solo para el  usuraio
    public ArrayList ocultar;
    //Tambien se puede usar Strings en caso de usos especiales

    public jugador(){
        mano=new ArrayList();
        ocultar=new ArrayList();
    }

    public jugador(String nombre){
        mano=new ArrayList();
        ocultar=new ArrayList();
        this.nombre=nombre;
    }

    public void reiniciarMano(){
        mano=new ArrayList();
        ocultar=new ArrayList();
    }



    //se debe usar el jugador.atributo.add();, el .get(); o el .remove();
}
