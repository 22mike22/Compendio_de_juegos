package com.example.compendiodejuegos.Blackjack21;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compendiodejuegos.juegoDeCartas.Naipes;
import com.example.compendiodejuegos.juegoDeCartas.jugador;

import java.util.ArrayList;

public class JugadorDeBlackjack extends jugador {
    public int fichas;
    JugadorDeBlackjack(String nombre) {
        super(nombre);
        fichas=1000;
    }
    JugadorDeBlackjack(){
        super();
        fichas=10000;
    }

    public void cartasIniciales(Naipes baraja){
        mano.add(baraja.obtener_cartas(1).get(0));
        mano.add(baraja.obtener_cartas(1).get(0));
        ocultar.add(0);//a la vista de todos
        ocultar.add(0);//oculta a todos
    }

    public int calcularMano() {
        int sumaDeMano = 0;
        int aux;
        for (int c = 0; c < mano.size(); c++) {//se analiza carta por carta
            aux = numeroSinTipo((Integer) mano.get(c));//se obtiene el valor de la carta limpiando el tipo
            switch(aux){//cartas especiales del blacjkack
                case 10://corresponden al j k q
                case 11:
                case 12:
                    aux=9;
                    break;
                case 0://corresponde al as
                    if(sumaDeMano+11>21) aux=0;//se verifica que la suma del as no pase de 21
                    else aux=10;//si no se pasa se elige 11 si no el 1
                    break;
                default:
            }
            sumaDeMano += aux+1;//se le suma 1 debido a que la cuenta inicia desde 0 no desde 1
        }
        return sumaDeMano;
    }

    public int numeroSinTipo(int numero){
        return numero - ((int) (numero / 13)) * 13;
    }

    public String simboloDeCarta(int numero){
        switch ((int)(numero/13)){
            case 0:
                return "♤";
            case 1:
                return "♧";
            case 2:
                return "♢";
            case 3:
                return "♡";
            default:
                return "error";
        }
    }

}

