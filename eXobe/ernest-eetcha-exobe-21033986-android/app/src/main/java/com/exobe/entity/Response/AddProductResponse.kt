package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class AddProductResponse {

    @SerializedName("result") val result : AddProductResult?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}
class AddProductResult {

    @SerializedName("productImage")
    val productImage: List<String>?=null
    @SerializedName("productFor")
    val productFor: String?=null
    @SerializedName("status")
    val status: String?=null
    @SerializedName("_id")
    val _id: String?=null
    @SerializedName("productName")
    val productName: String?=null
    @SerializedName("price")
    val price: Int?=null
    @SerializedName("unit")
    val unit: Int?=null
    @SerializedName("brand")
    val brand: String?=null
    @SerializedName("description")
    val description: String?=null
    @SerializedName("categoryId")
    val categoryId: String?=null
    @SerializedName("subCategoryId")
    val subCategoryId: String?=null
    @SerializedName("quantity")
    val quantity: Int?=null
    @SerializedName("userId")
    val userId: String?=null
    @SerializedName("createdAt")
    val createdAt: String?=null
    @SerializedName("updatedAt")
    val updatedAt: String?=null
    @SerializedName("__v")
    val __v: Int?=null
}