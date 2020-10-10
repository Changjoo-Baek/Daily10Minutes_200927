package com.zzazzu.daily10minutes_200927



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zzazzu.daily10minutes_200927.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        loginBtn.setOnClickListener{

// inputid 통해 받은 텍스트를 스트링으로 바꾸자라는 내
            val inputId = idEdt.text.toString()
            val inputpw = pwEdt.text.toString()

// 서버 유틸을 이용해서 실제 로그인 시도

            ServerUtil.postRequestLogin(inputId, inputpw)
        }


    }

    override fun setValues() {

    }

}