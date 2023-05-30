package com.example.proyectomovil;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SumaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        ImageButton microphoneButton = findViewById(R.id.btnMicro);
        microphoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarReconocimientoVoz(view);
            }
        });
    }
    public void iniciarReconocimientoVoz(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Habla ahora...");

        try {
            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "El reconocimiento de voz no está disponible en tu dispositivo.", Toast.LENGTH_SHORT).show();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (!matches.isEmpty()) {
                String speechText = matches.get(0);
                procesarTexto(speechText);
            }
        }
    }

    private void procesarTexto(String speechText) {
        try {
            double valor = Double.parseDouble(speechText);
            EditText num1 = findViewById(R.id.tpnum1);
            EditText num2 = findViewById(R.id.tpnum2);
            TextView total = findViewById(R.id.txtresultado);

            if (num1.isFocused()) {
                num1.setText(String.valueOf(valor));
            } else if (num2.isFocused()) {
                num2.setText(String.valueOf(valor));
            }

            double resultado = Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString());
            total.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El valor reconocido no es válido.", Toast.LENGTH_SHORT).show();
        }
    }


    public void regresarMenu(View view){
        this.finish();
    }

    public void Sumar(View view){

        EditText num1= (EditText) findViewById(R.id.tpnum1);
        EditText num2= (EditText) findViewById(R.id.tpnum2);
        TextView total=findViewById(R.id.txtresultado);

        double resultado=Double.parseDouble(num1.getText().toString())+Double.parseDouble(num2.getText().toString());


        total.setText(String.valueOf(resultado));
    }
}