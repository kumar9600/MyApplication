package ara.com.myapplication.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;

import ara.com.myapplication.Util.Utils;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            checkConnectivity(context);
        }
    }

    public void checkConnectivity(final Context context) {
        if (!isNetworkInterfaceAvailable(context)) {
            Utils.showToast(context,"You are OFFLINE!");
            return;
        }
       Utils.showToast(context,"You are ONLINE!");
    }

    //This only checks if the network interface is available, doesn't guarantee a particular network service is available, for example, there could be low signal or server downtime
    private boolean isNetworkInterfaceAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
