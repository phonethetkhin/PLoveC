package com.ptk.pnclovecounter.util

import com.ptk.pnclovecounter.model.data_model.ZodiacSign

data object ZodiacSigns {
    val signs = listOf(
        ZodiacSign("Capricorn", 12, 22, 1, 19),
        ZodiacSign("Aquarius", 1, 20, 2, 18),
        ZodiacSign("Pisces", 2, 19, 3, 20),
        ZodiacSign("Aries", 3, 21, 4, 19),
        ZodiacSign("Taurus", 4, 20, 5, 20),
        ZodiacSign("Gemini", 5, 21, 6, 20),
        ZodiacSign("Cancer", 6, 21, 7, 22),
        ZodiacSign("Leo", 7, 23, 8, 22),
        ZodiacSign("Virgo", 8, 23, 9, 22),
        ZodiacSign("Libra", 9, 23, 10, 22),
        ZodiacSign("Scorpio", 10, 23, 11, 21),
        ZodiacSign("Sagittarius", 11, 22, 12, 21)
    )
}