package dev.arogundade.library.data.models.account

data class InternalTransaction(
    val blockNumber: String,
    val contractAddress: String,
    val errCode: String,
    val from: String,
    val gas: String,
    val gasUsed: String,
    val input: String,
    val isError: String,
    val timeStamp: String,
    val to: String,
    val type: String,
    val value: String
)