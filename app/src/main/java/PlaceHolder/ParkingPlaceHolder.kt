package PlaceHolder

import Beans.Parking
import Resource.CreateParkingResource
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ParkingPlaceHolder {
    @GET("/parking")
    fun getListado():Call<List<Parking>>
    @GET("/parking/user/{id}")
    fun getParkingByUserId(@Path("id")userId: Long):Call<List<Parking>>
    @POST("/parking")
    fun createParking(@Body createParkingResource: CreateParkingResource): Call<Parking>
}