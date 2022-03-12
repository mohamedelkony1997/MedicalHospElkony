package com.example.hosp;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

@RequiresApi(api = Build.VERSION_CODES.M)
public class FingerPrintHandledLeaving extends FingerprintManager.AuthenticationCallback {
    private Context context;
    public FingerPrintHandledLeaving(Context context) {
        this.context=context;

    }
    public void startauth(FingerprintManager fingerprintManage,FingerprintManager.CryptoObject cryptoObject){
        CancellationSignal cancellationSignal=new CancellationSignal();
        fingerprintManage.authenticate(cryptoObject,cancellationSignal ,0,this,null);



    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("there was an auth error" + errString, false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("auth failed" ,false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("error"+ helpString, false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {

            this.update("Your leaving has been registered", true);
        }

    private void update(String s, boolean b) {
        TextView textViewfingerprintaleaving =(TextView) ((Activity)context).findViewById(R.id.textfingerprintleaving);
        ImageView imageViewfingerprint=(ImageView) ((Activity)context).findViewById(R.id.imagefingerleaving);

        textViewfingerprintaleaving.setText(s);
        if(b==false){
            textViewfingerprintaleaving.setTextColor(ContextCompat.getColor(context,R.color.hwhite));
        }else{

         textViewfingerprintaleaving.setTextColor(ContextCompat.getColor(context,R.color.hwhite));
        imageViewfingerprint.setImageResource(R.drawable.done);


        imageViewfingerprint.setAdjustViewBounds(true);
        }
    }
}
