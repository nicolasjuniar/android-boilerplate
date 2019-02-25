package com.juniar.ancodev.android_boilerplate

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val listUserData: MutableList<UserModel>
)

data class UserModel(
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String
)