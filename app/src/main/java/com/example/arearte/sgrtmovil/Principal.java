package com.example.arearte.sgrtmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Principal extends AppCompatActivity {

    LinearLayout ly, ly_cod,ly_movimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ly = (LinearLayout) findViewById(R.id.ly);

        ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ConsultaQRActivity.class);
                startActivity(i);
            }
        });


        ly_cod = (LinearLayout) findViewById(R.id.ly_cod);
        ly_cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),consulta_codigo.class);
                startActivity(i);
            }
        });

        ly_movimiento = (LinearLayout) findViewById(R.id.ly_movimiento);
        ly_movimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MovimientoActivity.class);
                startActivity(i);
            }
        });


    }





}
