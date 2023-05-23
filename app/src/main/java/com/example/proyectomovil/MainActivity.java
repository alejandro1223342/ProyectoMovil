package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Cambiar activity
    public void irSuma(View view){
        //Indica que actividad va a realizar
        Intent intent = new Intent(this, SumaActivity.class);

        //Ciclo de vida de la actividad
        view.getContext().startActivity(intent);


    }
}