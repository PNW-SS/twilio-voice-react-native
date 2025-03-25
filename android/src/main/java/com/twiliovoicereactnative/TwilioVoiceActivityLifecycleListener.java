package com.twiliovoicereactnative.ExpoModule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import com.twiliovoicereactnative.VoiceActivityProxy;

public class TwilioVoiceActivityLifecycleListener implements ReactActivityLifecycleListener {

    private VoiceActivityProxy voiceActivityProxy;

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        voiceActivityProxy = new VoiceActivityProxy(activity, permission -> {
        });
        voiceActivityProxy.onCreate(savedInstanceState);
    }

    @Override
    public boolean onNewIntent(Intent intent) {
        if (voiceActivityProxy != null) {
            voiceActivityProxy.onNewIntent(intent);
        }
        return false;
    }

    @Override
    public void onDestroy(Activity activity) {
        if (voiceActivityProxy != null) {
            voiceActivityProxy.onDestroy();
        }
    }
}
