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

                        val dataObj = json.getJSONObject("data")
                        val userObj = dataObj.getJSONObject("user")

                        val userNickName = userObj.getString("nick_name")

                        runOnUiThread {
                            Toast.makeText(mContext,"$(userNickName)님 환영합니다!", Toast.LENGTH_SHORT).show()
                        }

//                         어디서 데이터를 꺼내는지가 중요하다. user objsms jsonOBJ가 아니라 dataObj에서 꺼내야 함.)


//                        응용문제 : 로그인 성공시 로그인한 사용자의 닉네임 토스트 출력
//                        json > data . user> nick_name 추

                    }
                    else {
//                        로그인 실패 => 토스트로 로그인 실패 안내.
//                        토스트 : UI 동작 -> UI Thread가 실행하도록 해야 함.

//                        연습문제 : 로그인 실패시 실패 사유를 서버가 알려주는 이유로 출력.

                        val message = json.getString("message")

                        runOnUiThread {
                            Toast.makeText(mContext, "로그인 실패", Toast.LENGTH_SHORT).show()
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