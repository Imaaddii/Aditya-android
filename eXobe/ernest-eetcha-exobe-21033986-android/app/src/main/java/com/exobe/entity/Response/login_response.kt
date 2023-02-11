package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class login_response {

    @SerializedName("result")
    val result: loginResult?=null
    @SerializedName("responseMessage")
    val responseMessage: String?=null
    @SerializedName("responseCode")
    var responseCode: Int?=null
}

class loginResult {

    @SerializedName("_id")
    val _id: String?=null
    @SerializedName("email")
    val email: String?=null
    @SerializedName("userType")
    val userType: String?=null
    @SerializedName("firstName")
    val firstName: String?=null
    @SerializedName("lastName")
    val lastName: String?=null
    @SerializedName("token")
    val token: String?=null
    @SerializedName("otpVerification")
    val otpVerification : Boolean?=false
}