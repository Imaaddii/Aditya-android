package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class viewdeals_response {
    @SerializedName("result") val result : viewdealsResult?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}
class viewdealsResult {

    @SerializedName("disCountType")
    val disCountType: String?=null
    @SerializedName("dealsFor")
    val dealsFor: String?=null
    @SerializedName("productId")
    val productId: List<viewdealsProductId>?=null
    @SerializedName("serviceId")
    val serviceId: List<String>?=null
    @SerializedName("expired")
    val expired: Boolean?=null
    @SerializedName("status")
    val status: String?=null
    @SerializedName("_id")
    val _id: String?=null
    @SerializedName("dealName")
    val dealName: String?=null
    @SerializedName("dealImage")
    val dealImage: String?=null
    @SerializedName("description")
    val description: String?=null
    @SerializedName("dealPrice")
    val dealPrice: Int?=null
    @SerializedName("dealStartTime")
    val dealStartTime: String?=null
    @SerializedName("dealEndTime")
    val dealEndTime: String?=null
    @SerializedName("dealType")
    val dealType: String?=null
    @SerializedName("userId")
    val userId: String?=null
    @SerializedName("createdAt")
    val createdAt: String?=null
    @SerializedName("updatedAt")
    val updatedAt: String?=null
    @SerializedName("__v")
    val __v: Int?=null
}

class viewdealsProductId {

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
    @SerializedName("description")
    val description: String?=null
    @SerializedName("brand")
    val brand: String?=null
    @SerializedName("categoryId")
    val categoryId: CategoryId?=null
    @SerializedName("subCategoryId")
    val subCategoryId: SubCategoryId?=null
    @SerializedName("quantity")
    val quantity: Int?=null
    @SerializedName("productReferenceId")
    val productReferenceId: String?=null
    @SerializedName("userId")
    val userId: String?=null
    @SerializedName("createdAt")
    val createdAt: String?=null
    @SerializedName("updatedAt")
    val updatedAt: String?=null
    @SerializedName("__v")
    val __v: Int?=null
}