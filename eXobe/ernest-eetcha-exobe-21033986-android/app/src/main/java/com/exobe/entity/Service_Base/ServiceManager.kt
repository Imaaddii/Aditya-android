package com.exobe.entity.Service_Base

import android.annotation.SuppressLint
import android.content.Context
import com.exobe.entity.ApiCallBack
import com.exobe.entity.Request.SignupRequest
import com.exobe.entity.Response.*
import com.google.gson.JsonObject


class ServiceManager(var mContext: Context?) {

    private val accessToken: String? = null

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var mServiceManager: ServiceManager? = null
        fun getInstance(context: Context?): ServiceManager? {
            if (mServiceManager == null) {
                mServiceManager = ServiceManager(context)
            }
            return mServiceManager
        }
    }

    fun SignupApi(callBack: ApiCallBack<SignupResponse>, signupRequest: SignupRequest) {
        mContext?.let { Remotedatasource.current(it, false)!!.SignupApi(signupRequest) }!!
            .enqueue(callBack)
    }
    fun LoginApi(callBack: ApiCallBack<login_response>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, false)!!.LoginApi(jsonObject) }!!
            .enqueue(callBack)
    }
    fun HomeApi(callBack: ApiCallBack<Home_response>) {
        mContext?.let { Remotedatasource.current(it, false)!!.HomeApi() }!!
            .enqueue(callBack)
    }

    fun forgotpasswordApi(callBack: ApiCallBack<forgotpassword_response>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, false)!!.forgotpasswordApi(jsonObject) }!!
            .enqueue(callBack)
    }

    fun ResendOtpApi(callBack: ApiCallBack<ResendOtp>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, false)!!.ResendotpApi(jsonObject) }!!
            .enqueue(callBack)
    }
   fun otpverficationApi(callBack: ApiCallBack<otpverfication_response>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, false)!!.otpApi(jsonObject) }!!
            .enqueue(callBack)
    }

    fun ResetPasswordApi(callBack: ApiCallBack<resetpassword_response>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, false)!!.ResetPasswordApi(jsonObject) }!!
            .enqueue(callBack)
    }

    fun productListByCategoryApi(callBack: ApiCallBack<productListByCategory_response>, id: String) {
        mContext?.let { Remotedatasource.current(it, false)!!.productListByCategoryApi(id) }!!
            .enqueue(callBack)
    }

    fun listCategoryApi(callBack: ApiCallBack<CategoryList_response>) {
        mContext?.let { Remotedatasource.current(it, false)!!.listCategoryApi() }!!
            .enqueue(callBack)
    }

    fun listSubCategoryApi(callBack: ApiCallBack<SubCategoryResponse>, id: String) {
        mContext?.let { Remotedatasource.current(it, false)!!.listSubCategoryApi(id) }!!
            .enqueue(callBack)
    }
    fun serviceListApi(callBack: ApiCallBack<ServiceList_Response>) {
        mContext?.let { Remotedatasource.current(it, false)!!.serviceListApi() }!!
            .enqueue(callBack)
    }

    fun ProductListApi(callBack: ApiCallBack<ProductList_response>) {
        mContext?.let { Remotedatasource.current(it, false)!!.listProductApi() }!!
            .enqueue(callBack)
    }

    fun customerdealsListApi(callBack: ApiCallBack<customerdeals_response>) {
        mContext?.let { Remotedatasource.current(it, false)!!.dealListapi() }!!
            .enqueue(callBack)
    }

    fun customerdealsViewApi(callBack: ApiCallBack<viewdeals_response>,id: String) {
        mContext?.let { Remotedatasource.current(it, false)!!.dealViewapi(id) }!!
            .enqueue(callBack)
    }

    fun changepasswordApi(callBack: ApiCallBack<changepasswordresponse>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.Changepassword(jsonObject) }!!
            .enqueue(callBack)
    }
    fun profileApi(callBack: ApiCallBack<getprofile_response>) {
        mContext?.let { Remotedatasource.current(it, true)!!.ProfileApi() }!!
            .enqueue(callBack)
    }
    fun staticDataApi(callBack: ApiCallBack<StaticContentResponse>, type: String) {
        mContext?.let { Remotedatasource.current(it, false)!!.static_content(type) }!!
            .enqueue(callBack)
    }
    fun addressListApi(callBack: ApiCallBack<AddresslistResponse>) {
        mContext?.let { Remotedatasource.current(it, true)!!.listAddressApi() }!!
            .enqueue(callBack)
    }
    fun Updateprofileapi(callBack: ApiCallBack<update_profile_response>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.Updateprofileapi(jsonObject) }!!
            .enqueue(callBack)
    }
    fun AddAddressapi(callBack: ApiCallBack<AddAddressResponse>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.AddAddressapi(jsonObject) }!!
            .enqueue(callBack)
    }
    fun fillformapi(callBack: ApiCallBack<RetailerFillformResponse>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.fillformapi(jsonObject) }!!
            .enqueue(callBack)
    }
    fun orderListapi(callBack: ApiCallBack<PendingOrderRetailerResponse>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.orderListapi(jsonObject) }!!
            .enqueue(callBack)
    }
    fun HomeRetailerApi(callBack: ApiCallBack<Home_response>) {
        mContext?.let { Remotedatasource.current(it, true)!!.HomeRetailerApi() }!!
            .enqueue(callBack)
    }
    fun addproductapi(callBack: ApiCallBack<AddProductResponse>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.addproductApi(jsonObject) }!!
            .enqueue(callBack)
    }

    fun WishListApi(callBack: ApiCallBack<WishlistResponse>) {
        mContext?.let { Remotedatasource.current(it, true)!!.WishlistApi() }!!
            .enqueue(callBack)
    }
    fun addTowishlistApi(callBack: ApiCallBack<WishlistResponse>, productId: String) {
        mContext?.let { Remotedatasource.current(it, true)!!.addwishlistApi(productId) }!!
            .enqueue(callBack)

    }
    fun viewProductApi(callBack: ApiCallBack<ViewProductResponse>,productId:String) {
        mContext?.let { Remotedatasource.current(it, false)!!.viewProductApi(productId) }!!
            .enqueue(callBack)
    }
    fun RateThisAppApi(callBack: ApiCallBack<RateThisAppResponse>, jsonObject: JsonObject) {
        mContext?.let { Remotedatasource.current(it, true)!!.RateThisAppApi(jsonObject) }!!
            .enqueue(callBack)
    }

}





