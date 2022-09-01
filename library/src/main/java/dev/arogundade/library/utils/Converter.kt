package dev.arogundade.library.utils

object Converter {

    fun weiToBnb(value: Number): Double {
        return value.toDouble() * BNB / Wei
    }


    private const val Wei = 1000000000000000000.0
    private const val KWei = 1000000000000000.0
    private const val MWei = 1000000000000.0
    private const val GWei = 1000000000.0
    private const val Szabo = 1000000.0
    private const val Finney = 1000.0
    private const val BNB = 1.0
}
