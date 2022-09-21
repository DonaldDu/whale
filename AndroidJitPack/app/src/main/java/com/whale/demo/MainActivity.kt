package com.whale.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.whale.demo.R
import com.whale.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            btInitHook.setOnClickListener {
                it.isEnabled = false
                WhaleHook.init()
            }

            btAndroidId.setOnClickListener {
                showAndroidId()
            }
        }
    }

    @SuppressLint("HardwareIds")
    private fun showAndroidId() {
        val androidId = android.provider.Settings.Secure.getString(contentResolver, android.provider.Settings.Secure.ANDROID_ID)
        Toast.makeText(this, "androidId:$androidId", Toast.LENGTH_LONG).show()
    }
}