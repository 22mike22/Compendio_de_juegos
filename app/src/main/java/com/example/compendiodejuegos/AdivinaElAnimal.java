package com.example.compendiodejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdivinaElAnimal extends AppCompatActivity implements View.OnClickListener {

    String[] animales={"perro","gato","caballo","tigre","oso","leon","aguila"};
    int intentos=3;
    Button btnAdivinar;
    TextView txtIntentos,txtEspera;
    EditText etxtAnimal;
    ImageView imgAnimal;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_el_animal);

        btnAdivinar=findViewById(R.id.btnAdivinar);
        txtIntentos=findViewById(R.id.txtIntentos);
        etxtAnimal=findViewById(R.id.etxtAnimal);
        imgAnimal=findViewById(R.id.imgAnimal);
        txtEspera=findViewById(R.id.txtEspera);
        txtIntentos.setText("Tienes "+intentos+" ");
        r=nRadom();
        newGame(r);

        btnAdivinar.setOnClickListener(this);
    }

    private int nRadom(){
        return (int)(Math.random()*animales.length);
    }

    @Override
    public void onClick(View v) {
        String res=etxtAnimal.getText().toString().toLowerCase();
        if(res.equals(animales[r])){
            Toast.makeText(this, "Adivinaste el animal!", Toast.LENGTH_LONG).show();
            espera();
        }else {
            Toast.makeText(this, "Animal incorrecto",Toast.LENGTH_LONG).show();
            intentos--;
            txtIntentos.setText(intentos+"");
        }
        if (intentos==0){
            newGame(r);
        }

    }

    public void newGame(int n){
        int rAnimal=getResources().getIdentifier(animales[n],"drawable",getPackageName());
        imgAnimal.setImageResource(rAnimal);

    }

    private void espera(){
        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                txtEspera.setText("Nuevo animal en "+(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                r=nRadom();
                newGame(r);
            }
        }.start();
    }
}
