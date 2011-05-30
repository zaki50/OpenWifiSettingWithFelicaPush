
package org.zakky.openwifi;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;

import jp.andeb.kushikatsu.helper.KushikatsuHelper;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onButtonClick(View view) {
        final Intent intent = new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(KushikatsuHelper.buildIntentForSendIntent(intent));
    }

}
