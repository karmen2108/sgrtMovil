package com.example.arearte.sgrtmovil;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ConsultaQRActivity extends AppCompatActivity {
    public static TextView etScan;
    Button btnScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_qr);

        etScan = (TextView) findViewById(R.id.tvResultado);
        btnScan = (Button) findViewById(R.id.btnScan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //escanear();
                Intent intent = new Intent(getApplicationContext(), ScanCodeActivity.class);
                startActivity(intent);


            }
        });


    }
}
