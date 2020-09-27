package com.zzazzu.daily10minutes_200927.utils

import okhttp3.FormBody
import okhttp3.OkHttpClient

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

        }

    }

}