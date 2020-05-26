package com.example.compendiodejuegos;

import java.util.ArrayList;
import java.util.List;

public class Juego {



    private List<preguntas> preguntas;
    private int correctas;
    private int incorrectas;
    private int preguntasTotales;
    private int puntaje;
    private preguntas preguntaActual;

    public Juego(){
        correctas = 0;
        incorrectas = 0;
        preguntasTotales = 0;
        puntaje = 0;
        preguntaActual = new preguntas(10);
        preguntas = new ArrayList<preguntas>();
    }

    public void hacerNuevaPregunta(){
        preguntaActual = new preguntas(preguntasTotales *2+5);
        preguntasTotales++;
        preguntas.add(preguntaActual);
    }

    public boolean revisarRespuesta(int respuestaElegida){
        boolean correcta;
        if (preguntaActual.getRespuesta()==respuestaElegida){
            correctas++;
            correcta=true;
        }else{
            incorrectas++;
            correcta=false;
        }
        puntaje = correctas*10-incorrectas*30;
        return correcta;
    }

    public List<com.example.compendiodejuegos.preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<com.example.compendiodejuegos.preguntas> preguntas) {
        this.preguntas = preguntas;
    }

    public int getCorrectas() {
        return correctas;
    }

    public void setCorrectas(int correctas) {
        this.correctas = correctas;
    }

    public int getIncorrectas() {
        return incorrectas;
    }

    public void setIncorrectas(int incorrectas) {
        this.incorrectas = incorrectas;
    }

    public int getPreguntasTotales() {
        return preguntasTotales;
    }

    public void setPreguntasTotales(int preguntasTotales) {
        this.preguntasTotales = preguntasTotales;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public com.example.compendiodejuegos.preguntas getPreguntaActual() {
        return preguntaActual;
    }

    public void setPreguntaActual(com.example.compendiodejuegos.preguntas preguntaActual) {
        this.preguntaActual = preguntaActual;
    }


}
