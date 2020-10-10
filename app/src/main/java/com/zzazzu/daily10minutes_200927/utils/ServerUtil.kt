package com.zzazzu.daily10minutes_200927.utils

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {


// 화면(액티비티)의 입장에서, 서버응답이 들어왔을 때 어떤 행동을 실행할지
// 행동 지침을 담아주기 위한 인터페이스 (가이드북/ 매뉴얼) 정
// companion object 는 다른 파일에서 serverutil.porst~ 요렇게 바로 쓸 수 ㅣㅇㅆ게 해

    interface JsonResponseHandler {
        fun onResponse(json : JSONObject)



    }


    companion object {

        val HOST_URL = "http://15.164.153.174"

        fun postRequestLogin(
            id: String,
            pw: String,
            handler: JsonResponseHandler?
        ) {

            val client = OkHttpClient()

// 로그인 주소 : http://15.164.153.174/user 로 가야 한다고 적어줘야 하는데, 이거 다 적기 번거로우므로 변수로 만든 거입
            val urlString = "${HOST_URL}/user"

            val formData = FormBody.Builder()
                .add("email", id)
                .add("password", pw)
                .build()

// 요청의 모든 정보를 담고 있는 Request를 생성하자.
//            Intent 덩어리에 대응되는 개념.

            val request = Request.Builder()
                .url(urlString)
                .post(formData)
//                .header() // API가 header 데이터를 요구하면 담아주는 곳성
                .build()

// 먼저 어디로 갈 건가요 쓰고, 어떻게 갈 건가요, 뭘 들고 갈건요 쓰는 순서이다. 그리고나서 빌드 해주면 리퀘스트 완
// 완성된 request를 가지고 실제 서버 연결 코드

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
//                    서버에 연결 자체를 실패한 경우, (물리적 실패)
//                    인터넷 연결 실패 등등.
//                    아이디/비번 틀림 등 로그인 실패는 여기가 아님
                }

                override fun onResponse(call: Call, response: Response) {

//                    검사 결과가 성공이던, 실패던 관계 없이 서버가 뭔가 답변을 해주면 무조건 실행.
//                    서버가 내려준 응답 중 본문(body) 만 string 형태로 저장.

                    val bodyString = response.body!!.string()

//                    받아낸 string을 => 분석하기 용이한 jsonobject로 변환.

                    val jsonObj = JSONObject(bodyString)

                    Log.d("서버응답본문", jsonObj.toString())

//                    어떤 서버응답 처리를 해줄 지 가이드북 (인터페이스가 존재한다면,
//                    그 가이드북에 적힌 내용을 실제로 실행해달라는 코드.

                    handler?.onResponse(jsonObj)

                }

            })
        }

    }

}