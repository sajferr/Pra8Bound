package com.example.m.pra8bound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by m on 2016-07-04.
 */
public class Bounder extends Service {
    private final IBinder innbinder = new Bounder2();

    

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return innbinder;
    }


    public class Bounder2 extends Binder {
        Bounder getService() {
            Log.d("Uwaga", "Bounder2");
            return Bounder.this;

        }
    }


       public String  getFirstMessagee(){

            return "Siema stary, włączone";

        }

        public String getSecondMessage(){

            return"Dowidzenia stary, włączone ";


        }




    }



