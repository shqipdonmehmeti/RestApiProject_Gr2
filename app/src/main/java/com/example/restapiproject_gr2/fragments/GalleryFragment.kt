package com.example.restapiproject_gr2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.restapiproject_gr2.databinding.FragmentGalleryBinding
import com.example.restapiproject_gr2.helpers.Helpers
import com.example.restapiproject_gr2.models.DeviceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDeviceById()
    }

    private fun getDeviceById() {
        Helpers.provideRetrofitInstance().getDeviceByIdWithQueryParams("3").enqueue(object : Callback<List<DeviceResponse>?> {
            override fun onResponse(
                call: Call<List<DeviceResponse>?>,
                response: Response<List<DeviceResponse>?>
            ) {
                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    Log.d("TAG", "response is : ${response.body()?.get(0)}")
                }
            }

            override fun onFailure(call: Call<List<DeviceResponse>?>, t: Throwable) {
                Log.d("TAG", "error is : ${t.message}")
            }
        })
    }

}