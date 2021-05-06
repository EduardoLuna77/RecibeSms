package com.example.holamundoandroid.enviasms.recibesms.n17011191;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import org.w3c.dom.Text;

public class SMSReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        //Text =findViewById(R.id.textView);


        Bundle bundle = intent.getExtras();
        SmsMessage[] smsMessage=null;
        if(null != bundle){
            String informacion = "SMS recibido desde: ";
            Object [] pdus = (Object[]) bundle.get("pdus");
            smsMessage = new SmsMessage[pdus.length];
            for(int i=0; i<smsMessage.length; i++){
                smsMessage[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                informacion = informacion + smsMessage[i].getOriginatingAddress()+"\n";
                informacion = informacion + "................::::::::::Mensaje::::::::::................\n";
                informacion = informacion + smsMessage[i].getMessageBody().toString();
            }
            Toast.makeText(context, informacion,Toast.LENGTH_SHORT).show();


        }



    }
}
