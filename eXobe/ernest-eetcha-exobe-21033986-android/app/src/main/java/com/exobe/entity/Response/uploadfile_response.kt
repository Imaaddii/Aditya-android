package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class uploadfile_response {
    @SerializedName("result") val result : String?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}