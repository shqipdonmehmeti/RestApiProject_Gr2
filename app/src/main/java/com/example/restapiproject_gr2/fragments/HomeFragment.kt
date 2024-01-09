package com.example.restapiproject_gr2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restapiproject_gr2.databinding.FragmentHomeBinding
import com.example.restapiproject_gr2.helpers.Helpers
import com.example.restapiproject_gr2.models.DeviceData
import com.example.restapiproject_gr2.models.DeviceRequest
import com.example.restapiproject_gr2.models.DeviceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding.btnAddDevice.setOnClickListener {
            addObject()
        }
    }

    private fun addObject() {
        val deviceRequest = DeviceRequest(
            binding.etPhoneName.text.toString(), DeviceData(
                binding.etPhoneYear.text.toString().toInt(),
                binding.etPhonePrice.text.toString().toDouble(),
                binding.etPhoneCpuModel.text.toString(),
                binding.etPhoneHardDiskSize.text.toString()
            )
        )
        Helpers.provideRetrofitInstance().addDevice(deviceRequest).enqueue(object : Callback<DeviceResponse?> {
            override fun onResponse(
                call: Call<DeviceResponse?>,
                response: Response<DeviceResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body()
                    Toast.makeText(requireContext(),"Device was addedd successfully!",Toast.LENGTH_LONG).show()
                    val action = HomeFragmentDirections.actionNavHomeToHomeDetailsFragment(responseBody?.id)
                    findNavController().navigate(action)
                }
                else {
                    Toast.makeText(requireContext(),"Error while fetching data",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DeviceResponse?>, t: Throwable) {
                Toast.makeText(requireContext(),"Api call failed due to internet problems or connection timeout",Toast.LENGTH_LONG).show()
            }
        })
    }













}