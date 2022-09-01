package dev.arogundade.library.utils

sealed class Sort(val direction: String) {
    object Ascending : Sort("asc")
    object Descending : Sort("desc")
}