package PlaceHolder

import Beans.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserPlaceHolder {
    @GET("users")
    fun getListado():Call<List<User>>

    @GET("users/{id}")
    fun getUserId(@Path("id")id:Int):Call<User>
}