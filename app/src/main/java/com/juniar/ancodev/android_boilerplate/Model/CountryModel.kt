package com.juniar.ancodev.android_boilerplate.Model

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String,
    @SerializedName("flag") val flag: String
)