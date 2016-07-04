package com.example.m.pra8bound;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tekst;
    Bounder bounder ;
    boolean bolek =false;
    Bounder.Bounder2 podwojnyBounder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tekst = (TextView)findViewById(R.id.textView);
        Intent intent = new Intent(this,Bounder.class);
        bindService(intent,Sconnetcion,BIND_AUTO_CREATE);

    }



    public void second(View view) {
 String ing2 =bounder.getSecondMessage();
        tekst.setText(ing2);



    }

    public void first(View view) {
        String ing1 =bounder.getFirstMessagee();
        tekst.setText(ing1);






    }
    private ServiceConnection Sconnetcion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
             podwojnyBounder = (Bounder.Bounder2)service;
             bounder  = podwojnyBounder.getService();
             bolek =true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            bolek =false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if(bolek){
            unbindService(Sconnetcion);

        }
    }
}
