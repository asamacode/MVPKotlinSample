package com.asama.luong.mvpkotlinsample.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogoutResponse internal constructor(
    @Expose
    @SerializedName("status_code")
    private var statusCode: String? = null,
    @Expose
    @SerializedName("message")
    private var message: String? = null
)