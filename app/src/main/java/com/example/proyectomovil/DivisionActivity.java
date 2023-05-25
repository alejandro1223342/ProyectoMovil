package com.example.proyectomovil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DivisionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);
    }


    public void regresarMenu(View view){
        this.finish();
    }

    public void Dividir(View view){

        EditText num1= (EditText) findViewById(R.id.tpnum1);
        EditText num2= (EditText) findViewById(R.id.tpnum2);
        TextView total=findViewById(R.id.txtresultado);

        double resultado=Double.parseDouble(num1.getText().toString())/Double.parseDouble(num2.getText().toString());


        total.setText(resultado+"");

    }
}
