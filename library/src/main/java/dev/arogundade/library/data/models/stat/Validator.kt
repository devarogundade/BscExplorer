package dev.arogundade.library.data.models.stat

data class Validator(
    val validatorAddress: String,
    val validatorName: String,
    val validatorStatus: String,
    val validatorVotingPower: String,
    val validatorVotingPowerProportion: String
)