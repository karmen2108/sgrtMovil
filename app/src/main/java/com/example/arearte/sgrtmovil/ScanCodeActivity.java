package com.example.arearte.sgrtmovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    ZXingScannerView scannerView;
    String[] variables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);

        //setContentView(R.layout.activity_scan_code);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) {
        variables = result.toString().split(";");

        //ConsultaQRActivity.etScan.setText(result.getText());

        ConsultaQRActivity.etScan.setText(variables[0]);
        onBackPressed();

    }

    @Override
    protected void onPause() {
        super.onPause();

        scannerView.stopCamera();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
