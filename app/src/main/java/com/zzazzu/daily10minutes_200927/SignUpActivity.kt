package com.zzazzu.daily10minutes_200927

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }
}