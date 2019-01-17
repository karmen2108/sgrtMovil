package com.example.arearte.sgrtmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static EditText etUsuario, etPassword;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread tr=new Thread(){
                    @Override
                    public void run() {
                        final String res=enviarPost(etUsuario.getText().toString(),etPassword.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int r = objJSON(res);

                                if (r>0){
                                    Intent i = new Intent(getApplicationContext(),Principal.class);
                                    startActivity(i);
                                }else {
                                    Toast.makeText(getApplicationContext(), "Usuario o pass incorrecto", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                };
                tr.start();

            }
        });

    }

    public String enviarPost(String usuario, String password){
        String parametros="usu="+usuario+"&pas="+password;
        HttpURLConnection conection=null;
        String respuesta="";
        try {
            URL url=new URL("http://192.168.2.25/login2.php");
            conection=(HttpURLConnection)url.openConnection();
            conection.setRequestMethod("POST");
            conection.setRequestProperty("Content-Length",""+Integer.toString(parametros.getBytes().length));

            conection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conection.getOutputStream());

            wr.writeBytes(parametros);
            wr.close();

            Scanner inStream = new Scanner(conection.getInputStream());

            while (inStream.hasNextLine())
                respuesta+=(inStream.nextLine());

        }catch (Exception e){}
            return respuesta.toString();

    }

    public int objJSON(String respuesta){
        int rest = 0;
        try{
            JSONArray json=new JSONArray(respuesta);
            if (json.length()>0){
                rest=1;
            }

        }catch (Exception e){}
        return rest;
    }
}
