package com.exobe.customClicks

interface quantityCounter {
    fun decrement(position: Int, price: String?)
    fun increment(position: Int, price: String?)
}

interface CustomeClick {
    fun click(_id: String?)

}
interface CustomeClick2 {
    fun click2()

}
interface CustomeClick3 {
    fun click3(_id: String?, categoryName: String?)

}
interface CustomeClick4 {
    fun click4()

}

//interface CustomeClick5 {
//    fun click5(_id: String?)
//
//}

interface DealsForCustomer {
    fun click(flag: String, flag1: Boolean, _id: String)

}

interface ServicesClick {
    fun click(flag: String)

}

interface popupItemClickListner {
    fun getData(data: String, flag: String)
}
interface servicedeleteclick{
    fun pendingdeleteclick(position: Int)
}
interface viewserviceclick{
    fun viewservice()
}
interface serviceselectedclick{
    fun pendingclick(position: Int)
}
interface subserviceClick{
    fun subservice(flag: String)
}
interface wishlistcustomclick{
    fun wishlist(_id: String?)
}

interface categorynameclick {
    fun categoryname(_id: String?,categoryname:String)
}
