package dev.arogundade.library.utils

object Converter {

    fun convert(value: Double, from: Unit, to: Unit): Double {
        return (to.value * value) / from.value
    }

    sealed class Unit(val value: Double) {
        object Wei : Unit(1000000000000000000.0)
        object KWei : Unit(1000000000000000.0)
        object MWei : Unit(1000000000000.0)
        object GWei : Unit(1000000000.0)
        object Szabo : Unit(1000000.0)
        object Finney : Unit(1000.0)
        object BNB : Unit(1.0)
    }

}
