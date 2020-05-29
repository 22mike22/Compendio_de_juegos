package com.example.compendiodejuegos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compendiodejuegos.Blackjack21.Blackjack21;
import com.squareup.picasso.Picasso;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    Button botonTic, botonAhorcar;
    ImageView botonBlackjack, btnMates,btnAnimal;
    Intent iTic, iAho, iblackjack, iMates,iAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        botonTic = findViewById(R.id.buttonTicTac);
        botonAhorcar = findViewById(R.id.buttonAhorcado);
        botonBlackjack = findViewById(R.id.imagenBlackjack);
        btnMates= findViewById(R.id.imagenMates);
        btnAnimal=findViewById(R.id.imgAnimal);
        iTic = new Intent(this, Tic_tac.class);
        iAho = new Intent(this, Ahorcado.class);
        iblackjack = new Intent(this, Blackjack21.class);
        iMates = new Intent(this, Mates.class);
        iAnimal=new Intent(this,AdivinaElAnimal.class);
        botonTic.setOnClickListener(this);
        botonAhorcar.setOnClickListener(this);
        botonBlackjack.setOnClickListener(this);
        btnMates.setOnClickListener(this);
        btnAnimal.setOnClickListener(this);

        Picasso.get().load(R.drawable.blackjack_banner).into(botonBlackjack);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTicTac:
                startActivity(iTic);
                break;
            case R.id.buttonAhorcado:
                startActivity(iAho);
                break;
            case R.id.imagenBlackjack:
                startActivity(iblackjack);
                break;
            case R.id.imagenMates:
                startActivity(iMates);
                break;
            case R.id.imgAnimal:
                startActivity(iAnimal);
                break;
        }
    }
}
