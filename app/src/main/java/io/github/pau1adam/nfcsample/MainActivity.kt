package io.github.pau1adam.nfcsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendButton.setOnClickListener {
            startActivity(Intent(this, SendActivity::class.java))
        }
        receiveButton.setOnClickListener {
            startActivity(Intent(this, ReceiveActivity::class.java))
        }
    }
}
