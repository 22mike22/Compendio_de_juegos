package com.example.compendiodejuegos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compendiodejuegos.Blackjack21.Blackjack21;
import com.squareup.picasso.Picasso;

public class Menu extends AppCompatActivity /*implements View.OnClickListener*/ {

    ListView lstJuegos;
    Intent iTic, iAho, iblackjack, iMates,iAnimal;
    imagenes[] img={new imagenes(R.drawable.adivinaanimal),new imagenes(R.drawable.mates),
            new imagenes(R.drawable.black),new imagenes(R.drawable.tictactoe),new imagenes(R.drawable.ahorcado)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();


        lstJuegos=findViewById(R.id.lstJuegos);

        lstJuegos.setAdapter(new JuegosAdapter(this,R.layout.imagen,img));

        iTic = new Intent(this, Tic_tac.class);
        iAho = new Intent(this, Ahorcado.class);
        iblackjack = new Intent(this, Blackjack21.class);
        iMates = new Intent(this, Mates.class);
        iAnimal=new Intent(this,AdivinaElAnimal.class);

        lstJuegos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(iAnimal);
                }
                else if (position == 1) {
                    startActivity(iMates);
                }
                else if (position == 2) {
                    startActivity(iblackjack);
                }
                else if (position == 3) {
                    startActivity(iTic);
                }
                else if (position == 4) {
                    startActivity(iAho);
                }
            }
        });



    }






}
