package com.zzazzu.daily10minutes_200927



import android.os.Bundle
import android.util.Log
import com.zzazzu.daily10minutes_200927.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


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
            val inputPw = pwEdt.text.toString()

// 서버 유틸을 이용해서 실제 로그인 시도

            ServerUtil.postRequestLogin(inputId, inputPw, object : ServerUtil.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {

                    Log.d("메인화면", "로그인 응답 확인")
                }
            })

//
        }


    }

    override fun setValues() {

    }

}