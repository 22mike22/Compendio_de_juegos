package com.example.compendiodejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Mates extends AppCompatActivity {

    Button btnIr, btnResp1, btnResp2, btnResp3, btnResp4;
    TextView tvTiempo, tvPuntos, tvPregunta, tvMensaje;
    ProgressBar barraTiempo;

    Juego j = new Juego();
    int segundosRestantes =30;

    CountDownTimer tempo = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            segundosRestantes--;
            tvTiempo.setText(Integer.toString(segundosRestantes)+"seg");
            barraTiempo.setProgress(30-segundosRestantes);
        }

        @Override
        public void onFinish() {
            btnResp1.setEnabled(false);
            btnResp2.setEnabled(false);
            btnResp3.setEnabled(false);
            btnResp4.setEnabled(false);
            tvMensaje.setText("El tiempo se ha acabado"+ j.getCorrectas()+ "/"+ (j.getPreguntasTotales()-1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnIr.setVisibility(View.VISIBLE);
                }
            }, 4000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mates);

        btnIr= findViewById(R.id.btnIr);
        btnResp1 = findViewById(R.id.btnResp1);
        btnResp2 = findViewById(R.id.btnResp2);
        btnResp3 = findViewById(R.id.btnResp3);
        btnResp4 = findViewById(R.id.btnResp4);
        tvPregunta = findViewById(R.id.tvPregunta);
        tvTiempo = findViewById(R.id.tvTiempo);
        tvPuntos = findViewById(R.id.tvPuntos);
        tvMensaje = findViewById(R.id.tvMensaje);
        barraTiempo = findViewById(R.id.barraTiempo);

        tvMensaje.setText("Presiona Vamos");
        tvTiempo.setText("0seg");
        tvPregunta.setText("");
        tvPuntos.setText("0 puntos");


        View.OnClickListener empezarListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton_empezar = (Button) v;

                boton_empezar.setVisibility(View.INVISIBLE);
                segundosRestantes =30;
                j = new Juego();
                NuevoTurno();
                tempo.start();
            }
        };

        View.OnClickListener BotonRespuestaListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button BotonPresionado = (Button) v;

                int respuestaSeleccionada = Integer.parseInt(BotonPresionado.getText().toString());

                j.revisarRespuesta(respuestaSeleccionada);
                tvPuntos.setText(Integer.toString(j.getPuntaje())+"pts");
                NuevoTurno();
            }
        };

        btnIr.setOnClickListener(empezarListener);

        btnResp1.setOnClickListener(BotonRespuestaListener);
        btnResp2.setOnClickListener(BotonRespuestaListener);
        btnResp3.setOnClickListener(BotonRespuestaListener);
        btnResp4.setOnClickListener(BotonRespuestaListener);

    }

    private void NuevoTurno(){
        //crear una nueva pregunta}
        j.hacerNuevaPregunta();
        int [] respuesta = j.getPreguntaActual().getArregloRespuestas();

        // poner el terxto en los botones de respuesa
        btnResp1.setText(Integer.toString(respuesta[0]));
        btnResp2.setText(Integer.toString(respuesta[1]));
        btnResp3.setText(Integer.toString(respuesta[2]));
        btnResp4.setText(Integer.toString(respuesta[3]));

        btnResp1.setEnabled(true);
        btnResp2.setEnabled(true);
        btnResp3.setEnabled(true);
        btnResp4.setEnabled(true);

        tvPregunta.setText(j.getPreguntaActual().getFrase());

        tvMensaje.setText(j.getCorrectas()+"/"+ (j.getPreguntasTotales()-1));

        //activar los botones
        //empezar el temporizador
    }
}
