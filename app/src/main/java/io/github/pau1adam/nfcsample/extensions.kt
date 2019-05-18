package io.github.pau1adam.nfcsample

import android.content.Context
import android.nfc.Tag
import android.nfc.tech.MifareUltralight
import android.widget.Toast
import java.io.IOException
import java.nio.charset.Charset

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()