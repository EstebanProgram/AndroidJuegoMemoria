package com.example.memoriacardplaygoog;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public void pulsaGira(View view)
    {
        ImageView iv1 = (ImageView) view;

        int totaltime = 500;
        int frames = 30;
        int eachtime = totaltime/frames;

        CountDownTimer cdt = new CountDownTimer(totaltime, eachtime) {
            final float eachdegree = 360f/frames;
            float degrees = 0f;

            @Override
            public void onFinish() {
                iv1.setRotation(0);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                degrees += eachdegree;
                iv1.setRotation(degrees);
            }
        };
        cdt.start();
    }

    Memoria juego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton[] botones = {
                findViewById(R.id.imageButton2),
                findViewById(R.id.imageButton3),
                findViewById(R.id.imageButton4),
                findViewById(R.id.imageButton5),
                findViewById(R.id.imageButton6),
                findViewById(R.id.imageButton7),
                findViewById(R.id.imageButton8),
                findViewById(R.id.imageButton9),
        };

        int[] imagenes = {
                R.drawable.aerodactyl,
                R.drawable.arcanine,
                R.drawable.horsea,
                R.drawable.banette,
                R.drawable.charizard,
                R.drawable.buterfree,
                R.drawable.ditto,
                R.drawable.eevee,
                R.drawable.electabuzz,
                R.drawable.zapdos,
                R.drawable.vaporeon,
                R.drawable.snorlax,
                R.drawable.gyarados,
                R.drawable.tauros,
                R.drawable.jynx,
                R.drawable.shinx
        };

        int reverso = R.drawable.reverso;
        juego = new Memoria(MainActivity.this, botones, imagenes, reverso);
        juego.InitGame();

        for (int i = 0; i < botones.length; i++) {
            final int pos = i;
            botones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pulsaGira(v);
                    juego.DiscoverCard(pos);
                }
            });
        }
    }
}