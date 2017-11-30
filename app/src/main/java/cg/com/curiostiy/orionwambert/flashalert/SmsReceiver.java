package cg.com.curiostiy.orionwambert.flashalert;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.hardware.Camera;
import android.widget.Toast;


/**
 * Created by HP Notebook on 30/11/2017.
 */
public class SmsReceiver extends BroadcastReceiver{


    Camera camera;
    Camera.Parameters p;


    private final String sms="android.provider.Telephony.SMS_RECEIVED";



    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(sms)) {
            camera = Camera.open();
            p = camera.getParameters();
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
            Toast.makeText(context,"Alumage du Flahs",Toast.LENGTH_SHORT);

            stop();
            start();

            stop();
            start();
            stop();
            start();

            stop();
            start();
            stop();

        }
    }

    public void start(){
        try {
            Thread.sleep(1000);
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        try {
            Thread.sleep(1000);
            p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
