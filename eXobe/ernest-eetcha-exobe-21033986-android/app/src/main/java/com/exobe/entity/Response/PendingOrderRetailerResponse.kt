package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class PendingOrderRetailerResponse {

    @SerializedName("result")
    val result: PendingOrderRetailerResult? = null
    @SerializedName("responseMessage")
    val responseMessage: String? = null
    @SerializedName("responseCode")
    val responseCode: Int? = null

}

class PendingOrderRetailerResult {
    @SerializedName("docs")
    val docs: List<PendingOrderRetailerDocs>? = null

    @SerializedName("total")
    val total: Int? = null

    @SerializedName("limit")
    val limit: Int? = null

    @SerializedName("page")
    val page: Int? = null

    @SerializedName("pages")
    val pages: Int? = null
}

class PendingOrderRetailerDocs {

    @SerializedName("_id")
    val _id: String? = null

    @SerializedName("taxPrice")
    val taxPrice: Int? = null

    @SerializedName("dealId")
    val dealId: List<String>? = null

    @SerializedName("orderStatus")
    val orderStatus: String? = null

    @SerializedName("deliveryStatus")
    val deliveryStatus: String? = null

    @SerializedName("paymentStatus")
    val paymentStatus: String? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("actualPrice")
    val actualPrice: Int? = null

    @SerializedName("orderPrice")
    val orderPrice: Int? = null

    @SerializedName("userId")
    val userId: String? = null

    @SerializedName("productDetails")
    val productDetails: ProductDetails? = null

    @SerializedName("shippingAddress")
    val shippingAddress: String? = null

    @SerializedName("orderType")
    val orderType: String? = null

    @SerializedName("orderId")
    val orderId: String? = null

    @SerializedName("serviceDetails")
    val serviceDetails: List<String>? = null

    @SerializedName("createdAt")
    val createdAt: String? = null

    @SerializedName("updatedAt")
    val updatedAt: String? = null

    @SerializedName("__v")
    val __v: Int? = null

    @SerializedName("userDetails")
    val userDetails: UserDetails? = null

    @SerializedName("shippingAddressDetails")
    val shippingAddressDetails : ShippingAddressDetails?=null
}

class ShippingAddressDetails {

    @SerializedName("_id")
    val _id: String?=null
    @SerializedName("status")
    val status: String?=null
    @SerializedName("address")
    val address: String?=null
    @SerializedName("zipCode")
    val zipCode: Int?=null
    @SerializedName("state")
    val state: String?=null
    @SerializedName("city")
    val city: String?=null
    @SerializedName("country")
    val country: String?=null
    @SerializedName("firstName")
    val firstName: String?=null
    @SerializedName("lastName")
    val lastName: String?=null
    @SerializedName("mobileNumber")
    val mobileNumber: String?=null
    @SerializedName("countryCode")
    val countryCode: String?=null
    @SerializedName("email")
    val email: String?=null
    @SerializedName("transportName")
    val transportName: String?=null
    @SerializedName("gstNumber")
    val gstNumber: Int?=null
    @SerializedName("userId")
    val userId: String?=null
    @SerializedName("createdAt")
    val createdAt: String?=null
    @SerializedName("updatedAt")
    val updatedAt: String?=null
    @SerializedName("__v")
    val __v: Int?=null

}

class UserDetails {

    @SerializedName("_id")
    val _id: String? = null

    @SerializedName("storeLocation")
    val storeLocation: StoreLocation? = null

    @SerializedName("businessDetails")
    val businessDetails: BusinessDetails? = null

    @SerializedName("businessBankingDetails")
    val businessBankingDetails: BusinessBankingDetails? = null

    @SerializedName("serviceDetails")
    val serviceDetails: ServiceDetails? = null

    @SerializedName("address")
    val address: String? = null

    @SerializedName("otpVerification")
    val otpVerification: Boolean? = null

    @SerializedName("userVerification")
    val userVerification: Boolean? = null

    @SerializedName("profilePic")
    val profilePic: String? = null

    @SerializedName("websiteUrl")
    val websiteUrl: String? = null

    @SerializedName("duration")
    val duration: String? = null

    @SerializedName("userRequestStatus")
    val userRequestStatus: String? = null

    @SerializedName("zipCode")
    val zipCode: String? = null

    @SerializedName("eoriNumber")
    val eoriNumber: String? = null

    @SerializedName("additionalDocName")
    val additionalDocName: String? = null

    @SerializedName("additionalDocument")
    val additionalDocument: String? = null

    @SerializedName("ownerFirstName")
    val ownerFirstName: String? = null

    @SerializedName("ownerLastName")
    val ownerLastName: String? = null

    @SerializedName("ownerEmail")
    val ownerEmail: String? = null

    @SerializedName("noOfUniqueProducts")
    val noOfUniqueProducts: Int? = null

    @SerializedName("listOfBrandOrProducts")
    val listOfBrandOrProducts: List<String>? = null

    @SerializedName("keepStock")
    val keepStock: Boolean? = null

    @SerializedName("isPhysicalStore")
    val isPhysicalStore: Boolean? = null

    @SerializedName("preferredSupplierOrWholeSalerId")
    val preferredSupplierOrWholeSalerId: List<String>? = null

    @SerializedName("comments")
    val comments: String? = null

    @SerializedName("completeProfile")
    val completeProfile: Boolean? = null

    @SerializedName("flag")
    val flag: Int? = null

    @SerializedName("placeOrderCount")
    val placeOrderCount: Int? = null

    @SerializedName("serviceOrderCount")
    val serviceOrderCount: Int? = null

    @SerializedName("receiveOrderCount")
    val receiveOrderCount: Int? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("countryCode")
    val countryCode: String? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("firstName")
    val firstName: String? = null

    @SerializedName("lastName")
    val lastName: String? = null

    @SerializedName("mobileNumber")
    val mobileNumber: String? = null

    @SerializedName("password")
    val password: String? = null

    @SerializedName("userType")
    val userType: String? = null

    @SerializedName("otp")
    val otp: String? = null

    @SerializedName("otpExpireTime")
    val otpExpireTime: String? = null

    @SerializedName("createdAt")
    val createdAt: String? = null

    @SerializedName("updatedAt")
    val updatedAt: String? = null

    @SerializedName("__v")
    val __v: Int? = null
}
