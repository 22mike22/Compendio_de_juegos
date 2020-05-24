package com.example.compendiodejuegos.Blackjack21;

import com.example.compendiodejuegos.juegoDeCartas.Naipes;

public class Delear extends JugadorDeBlackjack{
    Delear(){
        super();
        fichas=2147483647;
    }
    public void jugar(Naipes naipes){
        ocultar.remove(1);
        ocultar.add(0);
        while (calcularMano()<16){
            mano.add(naipes.obtener_cartas(1).get(0));
            ocultar.add(0);
        }
    }

    public void cartasIniciales(Naipes naipes){
        super.cartasIniciales(naipes);
        ocultar.remove(1);//elimina la vision para poder remplazarla
        ocultar.add(2);//oculto para todos
    }
}
