package com.twiliovoicereactnative.ExpoModule;

import android.app.Application;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import com.twiliovoicereactnative.VoiceApplicationProxy;

public class TwilioVoiceApplicationLifecycleListener implements ApplicationLifecycleListener {

    private VoiceApplicationProxy voiceApplicationProxy;

    @Override
    public void onCreate(Application application) {
        // Initialize Twilio Voice Application proxy on app launch
        voiceApplicationProxy = new VoiceApplicationProxy(application);
        voiceApplicationProxy.onCreate();  // Hook Twilio SDK initialization&#8203;:contentReference[oaicite:2]{index=2}
    }

    // (No onDestroy hook here because Expo doesn't support Application.onTerminate in modules)
}
