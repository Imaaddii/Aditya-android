package com.exobe.entity.Service_Base


import android.telecom.Call
import com.exobe.Activities.Product_View
import com.exobe.Activities.ResetPassword
import com.exobe.entity.Request.SignupRequest
import com.exobe.entity.Response.*
import com.google.gson.JsonObject
import retrofit2.http.*


interface Api_interface {

    @POST("user/signUp")
    fun SignupApi(@Body signupRequest: SignupRequest): retrofit2.Call<SignupResponse>?

    @POST("user/uploadFile")
    fun uploadfileApi(@Body uploadfile: SignupRequest): retrofit2.Call<SignupResponse>?


    @POST("user/usersLogin")
    fun LoginApi(@Body jsonObject: JsonObject): retrofit2.Call<login_response>?

    @GET("user/homePage")
    fun HomeApi(): retrofit2.Call<Home_response>?

    @POST("user/forgotPassword")
    fun forgotpasswordApi(@Body jsonObject: JsonObject): retrofit2.Call<forgotpassword_response>?

    @POST("user/verifyOTP")
    fun otpApi(@Body jsonObject: JsonObject): retrofit2.Call<otpverfication_response>?

    @POST("user/resendOTP")
    fun ResendotpApi(@Body jsonObject: JsonObject): retrofit2.Call<ResendOtp>?

    @PUT("user/resetPassword")
    fun ResetPasswordApi(@Body jsonObject: JsonObject): retrofit2.Call<resetpassword_response>?

    @GET("product/productListByCategory")
    fun productListByCategoryApi(@Query("categoryId") id: String): retrofit2.Call<productListByCategory_response>?

    @POST("admin/listCategory")
    fun listCategoryApi(): retrofit2.Call<CategoryList_response>?

    @GET("admin/subcategoryListWithCategory")
    fun listSubCategoryApi(@Query("categoryId") id: String): retrofit2.Call<SubCategoryResponse>?

    @POST("service/serviceList")
    fun serviceListApi(): retrofit2.Call<ServiceList_Response>?

    @POST("product/productList")
    fun listProductApi(): retrofit2.Call<ProductList_response>?

    @POST("deal/listDeal")
    fun dealListapi(): retrofit2.Call<customerdeals_response>?

    @GET("deal/viewDeal")
    fun dealViewapi(
        @Query("dealId") id: String
    ): retrofit2.Call<viewdeals_response>?

    @PUT("user/changePassword")
    fun Changepassword(@Body jsonObject: JsonObject): retrofit2.Call<changepasswordresponse>?

    @GET("user/myProfile")
    fun ProfileApi(): retrofit2.Call<getprofile_response>?

    @GET("static/viewStaticContent")
    fun static_content(@Query("type") type: String): retrofit2.Call<StaticContentResponse>?

    @POST("user/listAddress")
    fun listAddressApi(): retrofit2.Call<AddresslistResponse>?

    @PUT("user/updateProfile")
    fun Updateprofileapi(@Body jsonObject: JsonObject): retrofit2.Call<update_profile_response>?

    @POST("user/addAddress")
    fun AddAddressapi(@Body jsonObject: JsonObject): retrofit2.Call<AddAddressResponse>?

    @POST("user/fillDetails")
    fun fillformapi(@Body jsonObject: JsonObject): retrofit2.Call<RetailerFillformResponse>?

    @POST("order/orderList")
    fun orderListapi(@Body jsonObject: JsonObject): retrofit2.Call<PendingOrderRetailerResponse>?

    @GET("user/homePageForRetailer")
    fun HomeRetailerApi(): retrofit2.Call<Home_response>?

    @POST("product/addProduct")
    fun addproductApi(@Body jsonObject: JsonObject): retrofit2.Call<AddProductResponse>?

    @GET("user/wishList")
    fun WishlistApi(): retrofit2.Call<WishlistResponse>?

    @POST("user/addWishListProduct")
    fun addwishlistApi(@Query("productId") productId: String): retrofit2.Call<WishlistResponse>?

    @POST("product/viewProduct")
    fun viewProductApi(@Query("productId") type: String): retrofit2.Call<ViewProductResponse>?
?
    @POST("user/addAppRating")
    fun RateThisAppApi(@Body jsonObject: JsonObject): retrofit2.Call<RateThisAppResponse>?
}