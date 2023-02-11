package com.exobe.entity.Response

import com.google.gson.annotations.SerializedName

class update_profile_response {
    @SerializedName("result") val result : update_profileResult? = null
    @SerializedName("responseMessage") val responseMessage : String? = null
    @SerializedName("responseCode") val responseCode : Int? = null
}
class update_profileResult {

    @SerializedName("storeLocation")
    val storeLocation: update_profileStoreLocation? = null
    @SerializedName("businessDetails")
    val businessDetails: update_profileBusinessDetails? = null
    @SerializedName("businessBankingDetails")
    val businessBankingDetails: update_profileBusinessBankingDetails? = null
    @SerializedName("serviceDetails")
    val serviceDetails: update_profileServiceDetails? = null
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
    @SerializedName("_id")
    val _id: String? = null
    @SerializedName("countryCode")
    val countryCode: Int? = null
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
    @SerializedName("otpExpireTime")
    val otpExpireTime: Int? = null
    @SerializedName("createdAt")
    val createdAt: String? = null
    @SerializedName("updatedAt")
    val updatedAt: String? = null
    @SerializedName("__v")
    val __v: Int? = null
}
class update_profileBusinessBankingDetails {

    @SerializedName("bankName")
    val bankName: String? = null
    @SerializedName("branchName")
    val branchName: String? = null
    @SerializedName("branchCode")
    val branchCode: String? = null
    @SerializedName("swiftCode")
    val swiftCode: String? = null
    @SerializedName("accountType")
    val accountType: String? = null
    @SerializedName("accountName")
    val accountName: String? = null
    @SerializedName("accountNumber")
    val accountNumber: String? = null
}

class update_profileBusinessDetails {

    @SerializedName("companyName")
    val companyName: String? = null
    @SerializedName("businessRegNumber")
    val businessRegNumber: String? = null
    @SerializedName("websiteUrl")
    val websiteUrl: String? = null
    @SerializedName("socialMediaAccounts")
    val socialMediaAccounts: String? = null
    @SerializedName("isVatRegistered")
    val isVatRegistered: Boolean? = null
    @SerializedName("vatNumber")
    val vatNumber: String? = null
    @SerializedName("monthlyRevenue")
    val monthlyRevenue: String? = null
}

 class update_profileServiceDetails {

    @SerializedName("noOfUniqueService")
    val noOfUniqueService: Int? = null
    @SerializedName("preferredSupplierOrWholeSalerId")
    val preferredSupplierOrWholeSalerId: List<String>? = null
    @SerializedName("comments")
    val comments: String? = null
    @SerializedName("listOfServices")
    val listOfServices: List<String>? = null
}
class update_profileStoreLocation {

    @SerializedName("type")
    val type: String? = null
    @SerializedName("coordinates")
    val coordinates: List<Int>? = null
}
