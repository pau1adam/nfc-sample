package io.github.pau1adam.nfcsample

import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.nfc.NfcEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.nfc.NdefRecord
import java.nio.charset.Charset


class SendActivity : AppCompatActivity(),
    NfcAdapter.OnNdefPushCompleteCallback,
    NfcAdapter.CreateNdefMessageCallback {

    val message = "potato"
    val nfcAdapter by lazy { NfcAdapter.getDefaultAdapter(this); }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        nfcAdapter.setNdefPushMessageCallback(this, this)
        nfcAdapter.setOnNdefPushCompleteCallback(this, this)
    }

    override fun onNdefPushComplete(event: NfcEvent?) = toast("message sent")

    override fun createNdefMessage(event: NfcEvent?): NdefMessage {
        //This will be called when another NFC capable device is detected.
        //We'll write the createRecords() method in just a moment
        val recordsToAttach = createRecords()
        //When creating an NdefMessage we need to provide an NdefRecord[]
        return NdefMessage(recordsToAttach)
    }

    private fun createRecords(): Array<NdefRecord> {
        val payload = message.toByteArray(Charset.forName("UTF-8"))
        val record = NdefRecord.createMime("text/plain", payload)
        return arrayOf(record)
    }
}
