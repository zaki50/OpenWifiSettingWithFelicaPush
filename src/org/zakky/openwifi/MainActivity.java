/*
 * Copyright 2010-2011 YAMAZAKI Makoto<makoto1975@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.zakky.openwifi;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import jp.andeb.kushikatsu.helper.KushikatsuHelper;

public class MainActivity extends Activity {
    private static final int KUSHIKATUS_PUSH_REQUEST_CODE = 1;
    private static final int KUSHIKATUS_INSTALL_REQUEST_CODE = 2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onButtonClick(View view) {
        final Intent intent = new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        KushikatsuHelper.startKushikatsuForResult(this,
                KushikatsuHelper.buildIntentForSendIntent(intent),
                KUSHIKATUS_PUSH_REQUEST_CODE, KUSHIKATUS_INSTALL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != KUSHIKATUS_PUSH_REQUEST_CODE
                && requestCode != KUSHIKATUS_INSTALL_REQUEST_CODE) {
            return;
        }
        if (resultCode == Activity.RESULT_OK
                || resultCode == KushikatsuHelper.RESULT_PUSH_REGISTERED) {
            Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NG", Toast.LENGTH_LONG).show();
        }
    }
}
