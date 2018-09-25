package ara.com.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ara.com.myapplication.service.MyService;
import ara.com.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private Button btnStartService, btnStopService, btnCheckNetworkConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    private void initializeViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        btnStartService = (Button) findViewById(R.id.startService);
        btnStopService = (Button) findViewById(R.id.stopService);
        btnCheckNetworkConnection = (Button) findViewById(R.id.btn_check);
    }

    private void initializeListeners() {
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getBaseContext(), MyService.class));
                Log.e(TAG, "starting service");
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getBaseContext(), MyService.class));
                Log.e(TAG, "Stopping service");
            }
        });

        btnCheckNetworkConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
