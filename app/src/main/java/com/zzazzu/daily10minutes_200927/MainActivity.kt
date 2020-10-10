package com.zzazzu.daily10minutes_200927



import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

//                    로그인 실행 결과에 따라 행동할 내용을 적는 공간.
//                    code라는 이름으로 적힌 Int값을 받아서, 200이냐 아니냐에 따라 다른 행동.

                    val codeNum = json.getInt("code")

                    Log.d("서버가 알려주는 코드", codeNum.toString())

                    if (codeNum == 200) {

                    }
                    else {
//                        로그인 실패 => 토스트로 로그인 실패 안내.
//                        토스트 : UI 동작 -> UI Thread가 실행하도록 해야 함.

                        runOnUiThread {
                            Toast.makeText(mContext, "로그인 실패", Toast.LENGTH_SHORT)
                        }

                    }

                }
            })

//
        }


    }

    override fun setValues() {

    }

}