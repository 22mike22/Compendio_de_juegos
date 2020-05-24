package com.example.compendiodejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.compendiodejuegos.Blackjack21.Blackjack21;
import com.squareup.picasso.Picasso;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    Button botonTic,botonAhorcar;
    ImageView botonBlackjack;
    Intent iTic, iAho, iblackjack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        botonTic=findViewById(R.id.buttonTicTac);
        botonAhorcar=findViewById(R.id.buttonAhorcado);
        botonBlackjack=findViewById(R.id.imagenBlackjack);
        iTic=new Intent(this,Tic_tac.class);
        iAho=new Intent(this, Ahorcado.class);
        iblackjack=new Intent(this, Blackjack21.class);
        botonTic.setOnClickListener(this);
        botonAhorcar.setOnClickListener(this);
        botonBlackjack.setOnClickListener(this);

        Picasso.get().load(R.drawable.blackjack_banner).into(botonBlackjack);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonTicTac:
                startActivity(iTic);
                break;
            case R.id.buttonAhorcado:
                startActivity(iAho);
                break;
            case R.id.imagenBlackjack:
                startActivity(iblackjack);
                break;
        }
    }
}