package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class WishlistResponse {

    @SerializedName("result") val result : List<WishlistResult>?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}
class WishlistResult {

    @SerializedName("isLike")
    val isLike: Boolean? = null
    @SerializedName("status")
    val status: String? = null
    @SerializedName("_id")
    val _id: String? = null
    @SerializedName("productId")
    val productId: WishlistProductId? = null
//    @SerializedName("userId")
//    val userId: UserId? = null
    @SerializedName("createdAt")
    val createdAt: String? = null
    @SerializedName("updatedAt")
    val updatedAt: String? = null
    @SerializedName("__v")
    val __v: Int? = null
}
class WishlistProductId {

    @SerializedName("productImage")
    val productImage: List<String>? = null
    @SerializedName("productFor")
    val productFor: String? = null
    @SerializedName("status")
    val status: String? = null
    @SerializedName("_id")
    val _id: String? = null
    @SerializedName("productName")
    val productName: String? = null
    @SerializedName("price")
    val price: Int? = null
    @SerializedName("unit")
    val unit: String? = null
    @SerializedName("brand")
    val brand: String? = null
    @SerializedName("description")
    val description: String? = null
    @SerializedName("quantity")
    val quantity: String? = null
    @SerializedName("productReferenceId")
    val productReferenceId: String? = null
    @SerializedName("userId")
    val userId: String? = null
    @SerializedName("createdAt")
    val createdAt: String? = null
    @SerializedName("updatedAt")
    val updatedAt: String? = null
    @SerializedName("__v")
    val __v: Int? = null
}
