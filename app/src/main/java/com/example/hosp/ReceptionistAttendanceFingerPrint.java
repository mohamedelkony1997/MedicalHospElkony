package com.example.hosp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceptionistAttendanceFingerPrint extends AppCompatActivity {
ImageView imageViewfinge;
TextView textViewfinger;
FingerprintManager fingerprintManager;
KeyguardManager keyguardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionistattendence_finger_print);
        imageViewfinge=findViewById(R.id.imagefinger);
        textViewfinger=findViewById(R.id.textfingerprint);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            fingerprintManager=(FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager=(KeyguardManager)getSystemService(KEYGUARD_SERVICE);
            if(!fingerprintManager.isHardwareDetected()){
                textViewfinger.setText("Fingerprint scanner not detected in devices");

            }else if(ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT)!= PackageManager.PERMISSION_GRANTED){
                textViewfinger.setText("permission not granted to use fingerprint scanner");
            }else if( !keyguardManager.isKeyguardSecure()){
                textViewfinger.setText("add lock to your phone in setting");
            }else if(!fingerprintManager.hasEnrolledFingerprints()){
                textViewfinger.setText("yo should add at least one finger to use this feature");
            }else{
                textViewfinger.setText("place your finger  on scanner to get attendence ");
                FingerPrintHandledAttendance fingerPrintHandledAttendance =new FingerPrintHandledAttendance(this);
                fingerPrintHandledAttendance.startauth(fingerprintManager,null);
            }
        }

    }


    public void backtothehome(View view) {
        Intent intent2=new Intent(ReceptionistAttendanceFingerPrint.this, AttendenceAndLeaving.class);
        startActivity(intent2);
    }
}