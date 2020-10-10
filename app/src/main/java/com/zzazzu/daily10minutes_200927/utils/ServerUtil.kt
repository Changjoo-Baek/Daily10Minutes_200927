package com.zzazzu.daily10minutes_200927.utils

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class ServerUtil {

// companion object 는 다른 파일에서 serverutil.porst~ 요렇게 바로 쓸 수 ㅣㅇㅆ게 해

    companion object {

        val HOST_URL = "http://15.164.153.174"

        fun postRequestLogin(id:String, pw:String) {

            val client = OkHttpClient()

// 로그인 주소 : http://15.164.153.174/user 로 가야 한다고 적어줘야 하는데, 이거 다 적기 번거로우므로 변수로 만든 거입
            val urlString = "$(HOST_URL)/user"

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

            client.newCall(request)
        }

    }

}