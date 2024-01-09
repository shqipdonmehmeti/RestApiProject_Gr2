package com.example.restapiproject_gr2.api

import com.example.restapiproject_gr2.api.ServiceApi.Companion.API_OBJECTS_ENDPOINT
import com.example.restapiproject_gr2.models.DeviceRequest
import com.example.restapiproject_gr2.models.DeviceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @POST(API_OBJECTS_ENDPOINT)
    fun addDevice(
        @Body deviceRequest: DeviceRequest
    ): Call<DeviceResponse>

    @GET("$API_OBJECTS_ENDPOINT/{id}")
    fun getDeviceById(@Path("id") id : String) : Call<DeviceResponse>

    @GET(API_OBJECTS_ENDPOINT)
    fun getDeviceByIdWithQueryParams(
        @Query("id") id : String
    ) : Call<List<DeviceResponse>>

    companion object {
        const val API_OBJECTS_ENDPOINT = "objects"
    }
}