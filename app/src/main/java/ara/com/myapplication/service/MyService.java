package ara.com.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import ara.com.myapplication.Util.Utils;

public class MyService extends Service {

    private static final String TAG = "MyService";
//    private MediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Utils.showToast(this,"Service started");
        Log.e(TAG, "Service started");
        /* player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();*/
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Utils.showToast(this,"Service stopped");
        Log.e(TAG, "Service stopped");
       /* player.stop();*/
    }
}
