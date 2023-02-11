package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class CategoryList_response {
    @SerializedName("result") val result : CategoryListResult?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}
class CategoryListResult {

    @SerializedName("docs")
    val docs: ArrayList<Docs>?=null
}
class Docs {

    @SerializedName("status")
    val status: String? = null
    @SerializedName("_id")
    val _id: String? = null
    @SerializedName("categoryName")
    val categoryName: String? = null
    @SerializedName("categoryImage")
    val categoryImage: String? = null
    @SerializedName("createdAt")
    val createdAt: String? = null
    @SerializedName("updatedAt")
    val updatedAt: String? = null
    @SerializedName("__v")
    val __v: Int? = null
}