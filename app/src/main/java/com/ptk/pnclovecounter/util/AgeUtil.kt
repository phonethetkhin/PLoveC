package com.ptk.pnclovecounter.util

import java.time.LocalDate

fun calculateAge(birthDay: Int, birthMonth: Int, birthYear: Int): Int {
    val currentDate = LocalDate.now() // Get the current date
    val currentYear = currentDate.year
    val currentMonth = currentDate.monthValue
    val currentDay = currentDate.dayOfMonth

    // Calculate age
    var age = currentYear - birthYear // 2024 - 1997 = 27

    // Check if the birthday has occurred this year // 6 < 6 = false  || (6 == 6 && 2 < 29)
    if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
        age-- // Subtract 1 from age if birthday hasn't occurred yet
    }

    return age
}