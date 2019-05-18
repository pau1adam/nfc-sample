package io.github.pau1adam.nfcsample

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_receive.*
import java.nio.charset.Charset


class ReceiveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            val receivedArray = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            if (receivedArray != null) {
                val receivedMessage = receivedArray[0] as NdefMessage
                val payload = receivedMessage.records[0].payload
                val message = payload.toString(Charset.forName("UTF-8"))
                dataTextView.text = "Received\n$message"
            } else {
                toast("Received Blank Parcel")
            }
        }
    }
}
