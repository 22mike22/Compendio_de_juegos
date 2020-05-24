package com.example.compendiodejuegos.Blackjack21;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compendiodejuegos.R;
import com.example.compendiodejuegos.juegoDeCartas.Naipes;
import com.squareup.picasso.Picasso;

public class Blackjack21 extends AppCompatActivity implements View.OnClickListener {
    Button apostar, quedar, doblar, pedir;
    EditText editApuesta;
    TextView textoJugador, textoDelear, textFichas;
    int apuesta;
    boolean noAposto = true;
    JugadorDeBlackjack jugador;
    Delear delear;
    Naipes naipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack21);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Poner imagen en el imagenView con picasso
        Picasso.get().load(R.drawable.black).resize(600, 600).into((ImageView) findViewById(R.id.imageView2));

        jugador = new JugadorDeBlackjack();
        delear = new Delear();

        naipes = new Naipes(1);

        apostar = findViewById(R.id.buttonApostar);
        quedar = findViewById(R.id.buttonQuedar);
        doblar = findViewById(R.id.buttonDoblar);
        pedir = findViewById(R.id.buttonPedir);

        editApuesta = findViewById(R.id.editTextApuesta);

        textoJugador = findViewById(R.id.textJugador);
        textoDelear = findViewById(R.id.textDelear);
        textFichas=findViewById(R.id.textViewFichas);

        textFichas.setText(jugador.fichas+"");

        apostar.setOnClickListener(this);
        quedar.setOnClickListener(this);
        doblar.setOnClickListener(this);
        pedir.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonApostar:
                apostar();
                break;
            case R.id.buttonQuedar:
                quedar();
                break;
            case R.id.buttonDoblar:
                doblar();
                break;
            case R.id.buttonPedir:
                pedir();
                break;
            default:
        }
        acutalizarCartas();
    }

    private void apostar() {
        CharSequence t = editApuesta.getText();
        if (noAposto) {
            try {
                apuesta = Integer.parseInt(t.toString());
            } catch (Exception e) {
                apuesta = 1;
            }
            noAposto = false;
            jugador.reiniciarMano();
            delear.reiniciarMano();
            jugador.cartasIniciales(naipes);
            delear.cartasIniciales(naipes);
            acutalizarCartas();
            if(jugador.calcularMano()==21){
                jugador.fichas+=apuesta*2;
                ganoJugador();
            }
        }
    }

    private void ganoJugador(){
        jugador.fichas+=apuesta;
        apuesta=0;
        noAposto=true;
        acutalizarCartas();
    }

    private void ganoDelear(){

        jugador.fichas-=apuesta;
        apuesta=0;
        noAposto=true;
        acutalizarCartas();
    }

    private void quedar() {
        if(!noAposto) {
            delear.jugar(naipes);
            if (delear.calcularMano() > 21) {
                ganoJugador();
            } else if (jugador.calcularMano() > 21) {
                ganoDelear();
            }else if(jugador.calcularMano()>delear.calcularMano()){
                ganoJugador();
            }else{
                ganoDelear();
            }
        }
    }

    private void doblar() {
        if(!noAposto){
            apuesta*=2;
            jugador.mano.add(naipes.obtener_cartas(1).get(0));
            jugador.ocultar.add(0);
            if(jugador.calcularMano()>21){
                ganoDelear();
            }
        }
    }

    private void pedir() {
        if(!noAposto){
            jugador.mano.add(naipes.obtener_cartas(1).get(0));
            jugador.ocultar.add(0);
            if(jugador.calcularMano()>21){
                ganoDelear();
            }
        }
    }

    private void acutalizarCartas() {
        textoJugador.setText(textoMano(jugador));
        textoDelear.setText(textoMano(delear));
        textFichas.setText(jugador.fichas+"");
    }

    private String textoMano(JugadorDeBlackjack jugador) {
        if (jugador.mano.size() == 0) return "|";
        String aux = "| ";
        int valorDeCarta;
        for (int i = 0; i < jugador.mano.size(); i++) {
            //mensaje(""+jugador.toString());
            valorDeCarta = jugador.numeroSinTipo((int) jugador.mano.get(i));
            if ((int) jugador.ocultar.get(i) == 0) {
                switch (valorDeCarta) {
                    case 10:
                        aux += "J";
                        break;
                    case 11:
                        aux += "Q";
                        break;
                    case 12:
                        aux += "K";
                        break;
                    case 0:
                        aux += "A";
                        break;
                    default:
                        aux += (valorDeCarta + 1);
                        break;
                }
                aux += jugador.simboloDeCarta((int) jugador.mano.get(i));
            } else {
                aux += "##";
            }
            aux += " | ";
        }
        return aux;
    }

    private void mensaje(CharSequence mensaje) {
        Toast t = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
        t.show();
    }
}
