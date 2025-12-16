package com.example.memoriacardplaygoog;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Memoria {
    private ImageButton[] ibArray;
    private int[] imgArray;
    private int backImg;
    private int[] posArray;
    private int firstCard = -1;
    private int secondCard = -1;
    private boolean isSelect = false;
    private Context context;

    public Memoria(Context context, ImageButton[] ibArray, int[] imgArray, int backImg) {
        this.context = context;
        this.ibArray = ibArray;
        this.imgArray = imgArray;
        this.backImg = backImg;
        this.posArray = new int[ibArray.length];
    }

    public void InitGame() {
        List<Integer> tempList = new ArrayList<>();
        List<Integer> copyImgList = new ArrayList<>();

        for (int i = 0; i < imgArray.length; i++)
        {
            copyImgList.add(imgArray[i]);
        }

        Random random = new Random();
        int pares = ibArray.length / 2;

        for (int i = 0; i < pares; i++)
        {
            int index = random.nextInt(copyImgList.size());
            int imagen = copyImgList.get(index);

            tempList.add(imagen);
            tempList.add(imagen);
            copyImgList.remove(index);
        }

        Collections.shuffle(tempList);
        for (int i = 0; i < ibArray.length; i++)
        {
            posArray[i] = tempList.get(i);
            ibArray[i].setImageResource(backImg);
        }
    }


    public void CleanImages() {
        for (int i = 0; i < ibArray.length; i++)
        {
            if (posArray[i] == -1)
            {
                ibArray[i].setVisibility(View.INVISIBLE);
            }
            else
            {
                ibArray[i].setImageResource(backImg);
            }
        }
    }

    public void DiscoverCard(int pos)
    {
        if (isSelect || posArray[pos] == -1)
        {
            return;
        }

        ibArray[pos].setEnabled(false);

        ibArray[pos].setImageResource(posArray[pos]);

        if (firstCard == -1)
        {
            firstCard = pos;
        }
        else
        {
            secondCard = pos;
            isSelect = true;
            for (int i = 0; i < ibArray.length; i++)
            {
                ibArray[i].setEnabled(false);
            }

            new CountDownTimer(1000, 1000)
            {
                public void onFinish() {
                    if (posArray[firstCard] == posArray[secondCard])
                    {
                        posArray[firstCard] = -1;
                        posArray[secondCard] = -1;
                    }
                    CleanImages();
                    firstCard = -1;
                    secondCard = -1;
                    isSelect = false;

                    if (IsFinished())
                    {
                        Toast.makeText(context, "¡Juego terminado!", Toast.LENGTH_LONG).show();

                        android.os.Handler handler = new android.os.Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ((MainActivity) context).finish();
                            }
                        }, 2000);

                    }
                }

                public void onTick(long millisUntilFinished) {}
            }.start();
            for (int i = 0; i < ibArray.length; i++)
            {
                ibArray[i].setEnabled(true);
            }
        }
    }

    public boolean IsFinished() {
        for (int i = 0; i < posArray.length; i++)
        {
            if (posArray[i] != -1)
            {
                return false;
            }
        }

        return true;
    }
}
