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


    private Camera camera;
    private Camera.Parameters p;


    private final String sms="android.provider.Telephony.SMS_RECEIVED";



    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(sms)) {
            camera = Camera.open();
            p = camera.getParameters();
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
            Toast.makeText(context,"Alumage du Flash",Toast.LENGTH_SHORT).show();

            stop();
            start();

            stop();
            start();

            stop();
            start();

            stop();
            start();

            Toast.makeText(context,"Arrêt du Flash",Toast.LENGTH_SHORT).show();
            stop();

        }
    }

    private void start(){
        try {
            Thread.sleep(1000);
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void stop(){
        try {
            Thread.sleep(1000);
            p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
