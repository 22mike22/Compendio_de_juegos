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

import java.util.Random;

public class AdivinaElAnimal extends AppCompatActivity implements View.OnClickListener {

    String[] animales={"perro","gato","caballo","tigre","oso","leon","aguila"};
    int intentos=3;
    Button btnAdivinar;
    TextView txtIntentos;
    EditText etxtAnimal;
    ImageView imgAnimal;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {mensaje("funciona");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_el_animal);
        mensaje("funciona");
        btnAdivinar=findViewById(R.id.btnAdivinar);
        txtIntentos=findViewById(R.id.txtIntentos);
        etxtAnimal=findViewById(R.id.etxtAnimal);
        imgAnimal=findViewById(R.id.imgAnimal);
        txtIntentos.setText(intentos+"");mensaje("funciona");
        r=nRadom();
        newGame(r);

        int rAnimal=getResources().getIdentifier(animales[1],"drawable",getPackageName());
        imgAnimal.setImageResource(rAnimal);

        btnAdivinar.setOnClickListener(this);
    }

    private int nRadom(){
        Random r=new Random(System.nanoTime());
        return r.nextInt(animales.length);

    }

    @Override
    public void onClick(View v) {
        String res=etxtAnimal.getText().toString().toLowerCase();
        if(res.equals(animales[r])){
            Toast.makeText(this, "Adivinaste el animal!", Toast.LENGTH_LONG).show();
            newGame(r);
        }else {
            Toast.makeText(this, "Animal incorrecto",Toast.LENGTH_LONG).show();
            intentos--;
            txtIntentos.setText(intentos+"");
            if (intentos==0){
                finish();
            }
        }

    }



    public void newGame(int n){
        int rAnimal=getResources().getIdentifier(animales[n],"drawable",getPackageName());
        imgAnimal.setImageResource(rAnimal);

    }

    private void mensaje(String mensaje){
        Toast t=Toast.makeText(this,mensaje,Toast.LENGTH_SHORT);
        t.show();
    }
}
