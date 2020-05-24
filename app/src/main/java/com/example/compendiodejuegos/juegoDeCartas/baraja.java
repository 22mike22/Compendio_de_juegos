package com.example.compendiodejuegos.juegoDeCartas;

import java.util.ArrayList;
import java.util.Random;

public class baraja {
    ArrayList cartas;
    boolean [][] descarte;
    int numDeBarajas, cartasRestantes;
    public String mensaje;
    baraja(ArrayList cartas, int numDeBarajas){
        this.cartas=cartas;
        this.numDeBarajas=numDeBarajas;
        descarte=new boolean[numDeBarajas][cartas.size()];
        for(int i=0;i<numDeBarajas;i++)
            for(int k=0;k<cartas.size();k++)
                descarte[i][k]=true;
        cartasRestantes=numDeBarajas*cartas.size();
    }

    baraja(int numDeBarajas){
        this.numDeBarajas=numDeBarajas;
    }

    public ArrayList obtener_cartas(int numDecartas){
        ArrayList cartasObtenidas=new ArrayList();
        Random r=new Random(System.currentTimeMillis());
        int aux=r.nextInt(numDeBarajas), aux2=r.nextInt(cartas.size());
        if(numDecartas>cartasRestantes){
            cartasRestantes-=numDecartas;
            while(numDecartas>0){
                if(descarte[aux][aux2]){
                    descarte[aux][aux2]=false;
                    cartasObtenidas.add(cartas.get(aux2));
                    numDecartas--;
                }
                aux=r.nextInt(numDeBarajas);
                aux2=r.nextInt(cartas.size());
            }
        }else{
            numDecartas=cartasRestantes;
            cartasRestantes=0;
            while(numDecartas>0){
                if(descarte[aux][aux2]){
                    descarte[aux][aux2]=false;
                    cartasObtenidas.add(cartas.get(aux2));
                    numDecartas--;
                }
                aux=r.nextInt(numDeBarajas);
                aux2=r.nextInt(cartas.size());
            }
            mensaje="Quedan menos cartas de las que se piden.";
        }
        return cartasObtenidas;
    }

    public void resetear_baraja(){
        descarte=new boolean[numDeBarajas][cartas.size()];
        for(int i=0;i<numDeBarajas;i++){
            for(int k=0;k<cartas.size();k++){
                descarte[i][k]=true;
            }
        }
    }

    public void resetear_baraja(int numBaraja){
        for(int k=0;k<cartas.size();k++){
            descarte[numBaraja][k]=true;
        }
    }


}
