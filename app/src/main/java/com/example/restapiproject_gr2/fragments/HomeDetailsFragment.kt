package com.example.restapiproject_gr2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.restapiproject_gr2.databinding.FragmentHomeDetailsBinding
import com.example.restapiproject_gr2.helpers.Helpers
import com.example.restapiproject_gr2.models.DeviceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentHomeDetailsBinding
    private val args : HomeDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDeviceById()
    }

    private fun getDeviceById() {
        Helpers.provideRetrofitInstance().getDeviceById(args.id ?: "").enqueue(object : Callback<DeviceResponse?> {
            override fun onResponse(
                call: Call<DeviceResponse?>,
                response: Response<DeviceResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val deviceResponse = response.body()
                    binding.tvShowDevice.text =
                        "Id: ${deviceResponse?.id} \n " +
                                "name: ${deviceResponse?.name} \n " +
                                "price : ${deviceResponse?.data?.price} \n "
                } else {
                    Toast.makeText(requireContext(),"Error while fetching data",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DeviceResponse?>, t: Throwable) {
                Toast.makeText(requireContext(),"Error",Toast.LENGTH_LONG).show()
            }
        })
    }








}