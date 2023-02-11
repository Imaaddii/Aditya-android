package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class StaticContentResponse {
    @SerializedName("result") val result : StaticContentResult?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}
class StaticContentResult {

    @SerializedName("status")
    val status: String?=null
    @SerializedName("_id")
    val _id: String?=null
    @SerializedName("type")
    val type: String?=null
    @SerializedName("title")
    val title: String?=null
    @SerializedName("description")
    val description: String?=null
    @SerializedName("createdAt")
    val createdAt: String?=null
    @SerializedName("updatedAt")
    val updatedAt: String?=null
    @SerializedName("__v")
    val __v: Int?=null
}