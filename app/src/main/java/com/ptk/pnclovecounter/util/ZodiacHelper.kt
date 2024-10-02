package com.ptk.pnclovecounter.util

import com.ptk.pnclovecounter.model.data_model.ZodiacSign


fun getZodiacSign(day: Int, month: Int, year: Int): String {
    for (sign in ZodiacSigns.signs) {
        if (isValidDate(day = day, month = month, year = year))
            if (isDateInRange(day = day, month = month, sign = sign)) {
                return sign.name
            }
    }
    return "Unknown"
}

/**
 * Checks if a given month and day fall within the zodiac sign's date range.
 *
 * @param day The birth day (1-31).
 * @param month The birth month (1-12).
 * @param sign The ZodiacSign object.
 * @return True if the date is within the sign's range, False otherwise.
 */
fun isDateInRange(day: Int, month: Int, sign: ZodiacSign): Boolean {
    return if (sign.startMonth < sign.endMonth) {
        // Zodiac sign does not span across two years
        // Check if the date is after the start date
        val afterStart =
            (month > sign.startMonth) || (month == sign.startMonth && day >= sign.startDay)
        // Check if the date is before the end date
        val beforeEnd = (month < sign.endMonth) || (month == sign.endMonth && day <= sign.endDay)
        // The date must satisfy both conditions
        afterStart && beforeEnd
    } else {
        // Zodiac sign spans across two years (e.g., Capricorn)
        // Check if the date is after the start date
        val afterStart =
            (month > sign.startMonth) || (month == sign.startMonth && day >= sign.startDay)
        // Check if the date is before the end date
        val beforeEnd = (month < sign.endMonth) || (month == sign.endMonth && day <= sign.endDay)
        // The date can satisfy either condition
        afterStart || beforeEnd
    }
}

fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun isValidDate(day: Int, month: Int, year: Int): Boolean {
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> day in 1..31 // Months with 31 days
        4, 6, 9, 11 -> day in 1..30      // Months with 30 days
        2 -> if (isLeapYear(year)) day in 1..29 else day in 1..28 // February
        else -> false // Invalid month
    }
}
