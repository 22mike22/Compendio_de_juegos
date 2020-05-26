package com.example.compendiodejuegos;

import java.util.Random;

public class preguntas {

    private int primerNumero;
    private int segundoNumero;
    private int respuesta;

    //hay 4 posibles respuestas para elegir
    private int [] arregloRespuestas;

    //cual de las 4 es la correcta
    private int posicionRespuesta;

    //el valos maximo del primer o segundo numero
    private int limiteSuperior;

    //el String con el que se escribira el problema
    private String frase;

    //genera la pregunt aleatoria

    public preguntas(int limiteSuperior){
        this.limiteSuperior = limiteSuperior;
        Random numeroAleatorio = new Random();

        this.primerNumero = numeroAleatorio.nextInt(limiteSuperior);
        this.segundoNumero = numeroAleatorio.nextInt(limiteSuperior);
        this.respuesta = this.primerNumero + this.segundoNumero;
        this.frase= primerNumero+ "+" + segundoNumero+ "=";

        this.posicionRespuesta = numeroAleatorio.nextInt(4);
        this.arregloRespuestas = new int[] {0,1,2,3};
        this.arregloRespuestas[0] = respuesta + 1;
        this.arregloRespuestas[1] = respuesta + 10;
        this.arregloRespuestas[2] = respuesta - 5;
        this.arregloRespuestas[3] = respuesta - 2;

        this.arregloRespuestas = RevolverArreglo(this.arregloRespuestas);

        arregloRespuestas[posicionRespuesta]=respuesta;

    }

    private int [] RevolverArreglo(int[] arreglo){
        int index, temp;
        Random generarNumero = new Random();

        for (int i = arreglo.length -1; i>0; i--){
            index = generarNumero.nextInt(i+1 );
            temp = arreglo[index];
            arreglo[index]=arreglo[i];
            arreglo[i] = temp;
        }
        return arreglo;
    }


    public int getPrimerNumero() {
        return primerNumero;
    }

    public void setPrimerNumero(int primerNumero) {
        this.primerNumero = primerNumero;
    }

    public int getSegundoNumero() {
        return segundoNumero;
    }

    public void setSegundoNumero(int segundoNumero) {
        this.segundoNumero = segundoNumero;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int[] getArregloRespuestas() {
        return arregloRespuestas;
    }

    public void setArregloRespuestas(int[] arregloRespuestas) {
        this.arregloRespuestas = arregloRespuestas;
    }

    public int getPosicionRespuesta() {
        return posicionRespuesta;
    }

    public void setPosicionRespuesta(int posicionRespuesta) {
        this.posicionRespuesta = posicionRespuesta;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(int limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
