package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class OrderHistoryRetailerResponse {
    @SerializedName("result") val result : OrderHistoryRetailerResult?=null
    @SerializedName("responseMessage") val responseMessage : String?=null
    @SerializedName("responseCode") val responseCode : Int?=null
}
class OrderHistoryRetailerResult {

    @SerializedName("docs")
    val docs: List<Docs>?=null
    @SerializedName("total")
    val total: Int?=null
    @SerializedName("limit")
    val limit: Int?=null
    @SerializedName("page")
    val page: Int?=null
    @SerializedName("pages")
    val pages: Int?=null
}

class OrderHistoryRetailerDocs {

    @SerializedName("_id")
    val _id: String?=null
    @SerializedName("taxPrice")
    val taxPrice: Int?=null
    @SerializedName("dealId")
    val dealId: List<String>?=null
    @SerializedName("orderStatus")
    val orderStatus: String?=null
    @SerializedName("deliveryStatus")
    val deliveryStatus: String?=null
    @SerializedName("paymentStatus")
    val paymentStatus: String?=null
    @SerializedName("status")
    val status: String?=null
    @SerializedName("actualPrice")
    val actualPrice: Int?=null
    @SerializedName("orderPrice")
    val orderPrice: Int?=null
    @SerializedName("userId")
    val userId: String?=null
    @SerializedName("productDetails")
    val productDetails: ProductDetails?=null
    @SerializedName("shippingAddress")
    val shippingAddress: String?=null
    @SerializedName("orderType")
    val orderType: String?=null
    @SerializedName("orderId")
    val orderId: String?=null
    @SerializedName("serviceDetails")
    val serviceDetails: List<String>?=null
    @SerializedName("createdAt")
    val createdAt: String?=null
    @SerializedName("updatedAt")
    val updatedAt: String?=null
    @SerializedName("__v")
    val __v: Int?=null
    @SerializedName("userDetails")
    val userDetails: UserDetails?=null
    @SerializedName("shippingAddressDetails")
    val shippingAddressDetails: ShippingAddressDetails?=null
}