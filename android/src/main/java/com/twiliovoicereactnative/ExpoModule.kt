package com.twiliovoicereactnative.ExpoModule

// import com.twilio.voice.Call
import com.twilio.voice.ConnectOptions
import com.twiliovoicereactnative.CallListenerProxy
import com.twiliovoicereactnative.CallRecord // not found
import com.twiliovoicereactnative.CallRecordDatabase
import com.twiliovoicereactnative.VoiceApplicationProxy
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import java.util.UUID

class ExpoModule : Module() {
  override fun definition() = ModuleDefinition {
    Function("voice_connect") { accessToken: String ->
      val context = appContext.reactContext
      if (context == null) {
        return@Function
      }

      val connectOptions = ConnectOptions.Builder(accessToken).build()
      val uuid = UUID.randomUUID()
      val callListenerProxy = CallListenerProxy(uuid, context)

      val callRecord =
              CallRecordDatabase.CallRecord(
                      uuid,
                      VoiceApplicationProxy.getVoiceServiceApi()
                              .connect(connectOptions, callListenerProxy),
                      "Callee", // provide a mechanism for determining the name of the callee
                      HashMap(), // provide a mechanism for passing custom TwiML parameters
                      CallRecord.Direction.Outgoing,
                      "Display Name" // provide a mechanism for determining the notification display
                      // name of the callee
                      )
      VoiceApplicationProxy.getCallRecordDatabase.add(callRecord)
    }
  }
}
