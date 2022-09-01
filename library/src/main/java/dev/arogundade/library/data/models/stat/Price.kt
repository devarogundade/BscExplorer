package dev.arogundade.library.data.models.stat

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("ethbtc")
    val bnbBtc: String,
    @SerializedName("ethbtc_timestamp")
    val bnbBtcTimeStamp: Long,
    @SerializedName("ethusd")
    val bnbUsd: String,
    @SerializedName("ethusd_timestamp")
    val bnbUsdTimeStamp: String
)