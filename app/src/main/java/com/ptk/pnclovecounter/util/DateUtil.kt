package com.ptk.pnclovecounter.util

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

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

fun getAnniDate(anniversaryDate: String, daysOnly: Boolean = false): Period {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val anniDate = LocalDate.parse(anniversaryDate, formatter)
    val currentDate = LocalDate.now()

    // Calculate the difference in years, months, and days using Period
    val period = Period.between(anniDate, currentDate)

    // Return a formatted result
    return period
}

fun getAnniDateDayOnly(anniversaryDate: String): Long {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val anniDate = LocalDate.parse(anniversaryDate, formatter)
    val currentDate = LocalDate.now()

    return (ChronoUnit.DAYS.between(anniDate, currentDate) + 1)
}
