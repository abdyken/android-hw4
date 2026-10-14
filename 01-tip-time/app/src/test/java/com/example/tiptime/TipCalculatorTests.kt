package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_15PercentWithRoundup() {
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = 12.0, tipPercent = 15.0, roundUp = true)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun toInputNumber_acceptsDotAndComma() {
        assertEquals(12.5, "12.5".toInputNumber(), 0.0)
        assertEquals(12.5, "12,5".toInputNumber(), 0.0)
    }

    @Test
    fun toInputNumber_returnsZeroForInvalidOrNegative() {
        assertEquals(0.0, "".toInputNumber(), 0.0)
        assertEquals(0.0, "abc".toInputNumber(), 0.0)
        assertEquals(0.0, "-50".toInputNumber(), 0.0)
    }
}
