package com.example.restapiproject_gr2.models

data class DeviceRequest(
    val name: String?,
    val data: DeviceData?
)

data class DeviceData(
    val year: Int?,
    val price: Double?,
    val cpuModel: String?,
    val hardDiskSize: String?
)

data class DeviceResponse(
    val id: String?,
    val name: String?,
    val data: DeviceData?,
    val createdAt: String?
)
