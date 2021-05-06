package com.example.holamundoandroid.enviasms.recibesms.n17011191;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     TextView Text  = findViewById(R.id.textView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkSMSStatePermission();

        setContentView(R.layout.activity_main);



    }

    private void checkSMSStatePermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.RECEIVE_SMS);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("mensaje", "No se tiene permiso para recibir SMS.");
            ActivityCompat.requestPermissions(this,new String [] {Manifest.permission.RECEIVE_SMS},225);
        }else{
            Log.i("mensaje","Si se tiene permiso para recibir SMS!");
        }

        permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_SMS);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("mensaje", "No se tiene permiso para leer SMS.");
            ActivityCompat.requestPermissions(this,new String [] {Manifest.permission.READ_SMS},225);
        }else{
            Log.i("mensaje","Si se tiene permiso para leer SMS!");
        }
    }



}