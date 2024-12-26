package io.github.alxiw.texttimer

import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import io.github.alxiw.texttimer.tools.CountTextFormatter
import junit.framework.TestCase.assertEquals

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.Locale

@RunWith(JUnit4::class)
class CountTextFormatterTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `format german numbers`() {
        ArrayList<Pair<Int, String>>().apply {
            add(Pair(Int.MIN_VALUE, ""))
            add(Pair(-1, ""))
            add(Pair(0, ""))
            add(Pair(1, "eins"))
            add(Pair(2, "zwei"))
            add(Pair(9, "neun"))
            add(Pair(10, "zehn"))
            add(Pair(11, "elf"))
            add(Pair(12, "zwölf"))
            add(Pair(13, "dreizehn"))
            add(Pair(18, "achtzehn"))
            add(Pair(19, "neunzehn"))
            add(Pair(20, "zwanzig"))
            add(Pair(21, "einsundzwanzig"))
            add(Pair(22, "zweiundzwanzig"))
            add(Pair(23, "dreiundzwanzig"))
            add(Pair(24, "vierundzwanzig"))
            add(Pair(29, "neunundzwanzig"))
            add(Pair(30, "dreißig"))
            add(Pair(55, "fünfundfünfzig"))
            add(Pair(69, "neunundsechzig"))
            add(Pair(99, "neunundneunzig"))
            add(Pair(100, "einhundert"))
            add(Pair(101, "einhunderteins"))
            add(Pair(109, "einhundertneun"))
            add(Pair(121, "einhunderteinsundzwanzig"))
            add(Pair(199, "einhundertneunundneunzig"))
            add(Pair(900, "neunhundert"))
            add(Pair(901, "neunhunderteins"))
            add(Pair(907, "neunhundertsieben"))
            add(Pair(909, "neunhundertneun"))
            add(Pair(910, "neunhundertzehn"))
            add(Pair(919, "neunhundertneunzehn"))
            add(Pair(920, "neunhundertzwanzig"))
            add(Pair(930, "neunhundertdreißig"))
            add(Pair(931, "neunhunderteinsunddreißig"))
            add(Pair(990, "neunhundertneunzig"))
            add(Pair(999, "neunhundertneunundneunzig"))
            add(Pair(1000, "eintausend"))
            add(Pair(1001, "∞"))
            add(Pair(1984, "∞"))
            add(Pair(Int.MAX_VALUE, "∞"))
        }.also { check(it, Locale.GERMANY) }
    }

    @Test
    fun `format english numbers`() {
        ArrayList<Pair<Int, String>>().apply {
            add(Pair(Int.MIN_VALUE, ""))
            add(Pair(-1, ""))
            add(Pair(0, ""))
            add(Pair(1, "one"))
            add(Pair(2, "two"))
            add(Pair(9, "nine"))
            add(Pair(10, "ten"))
            add(Pair(11, "eleven"))
            add(Pair(12, "twelve"))
            add(Pair(13, "thirteen"))
            add(Pair(18, "eighteen"))
            add(Pair(19, "nineteen"))
            add(Pair(20, "twenty"))
            add(Pair(21, "twenty-one"))
            add(Pair(22, "twenty-two"))
            add(Pair(23, "twenty-three"))
            add(Pair(24, "twenty-four"))
            add(Pair(29, "twenty-nine"))
            add(Pair(30, "thirty"))
            add(Pair(55, "fifty-five"))
            add(Pair(69, "sixty-nine"))
            add(Pair(99, "ninety-nine"))
            add(Pair(100, "one hundred"))
            add(Pair(101, "one hundred one"))
            add(Pair(109, "one hundred nine"))
            add(Pair(121, "one hundred twenty-one"))
            add(Pair(199, "one hundred ninety-nine"))
            add(Pair(900, "nine hundred"))
            add(Pair(901, "nine hundred one"))
            add(Pair(907, "nine hundred seven"))
            add(Pair(909, "nine hundred nine"))
            add(Pair(910, "nine hundred ten"))
            add(Pair(919, "nine hundred nineteen"))
            add(Pair(920, "nine hundred twenty"))
            add(Pair(930, "nine hundred thirty"))
            add(Pair(931, "nine hundred thirty-one"))
            add(Pair(990, "nine hundred ninety"))
            add(Pair(999, "nine hundred ninety-nine"))
            add(Pair(1000, "one thousand"))
            add(Pair(1001, "∞"))
            add(Pair(1984, "∞"))
            add(Pair(Int.MAX_VALUE, "∞"))
        }.also { check(it, Locale.US) }
    }

    @Test
    fun `format russian numbers`() {
        ArrayList<Pair<Int, String>>().apply {
            add(Pair(Int.MIN_VALUE, ""))
            add(Pair(-1, ""))
            add(Pair(0, ""))
            add(Pair(1, "один"))
            add(Pair(2, "два"))
            add(Pair(9, "девять"))
            add(Pair(10, "десять"))
            add(Pair(11, "одиннадцать"))
            add(Pair(12, "двенадцать"))
            add(Pair(13, "тринадцать"))
            add(Pair(18, "восемнадцать"))
            add(Pair(19, "девятнадцать"))
            add(Pair(20, "двадцать"))
            add(Pair(21, "двадцать один"))
            add(Pair(22, "двадцать два"))
            add(Pair(23, "двадцать три"))
            add(Pair(24, "двадцать четыре"))
            add(Pair(29, "двадцать девять"))
            add(Pair(30, "тридцать"))
            add(Pair(55, "пятьдесят пять"))
            add(Pair(69, "шестьдесят девять"))
            add(Pair(99, "девяносто девять"))
            add(Pair(100, "сто"))
            add(Pair(101, "сто один"))
            add(Pair(109, "сто девять"))
            add(Pair(121, "сто двадцать один"))
            add(Pair(199, "сто девяносто девять"))
            add(Pair(900, "девятьсот"))
            add(Pair(901, "девятьсот один"))
            add(Pair(907, "девятьсот семь"))
            add(Pair(909, "девятьсот девять"))
            add(Pair(910, "девятьсот десять"))
            add(Pair(919, "девятьсот девятнадцать"))
            add(Pair(920, "девятьсот двадцать"))
            add(Pair(930, "девятьсот тридцать"))
            add(Pair(931, "девятьсот тридцать один"))
            add(Pair(990, "девятьсот девяносто"))
            add(Pair(999, "девятьсот девяносто девять"))
            add(Pair(1000, "тысяча"))
            add(Pair(1001, "∞"))
            add(Pair(1984, "∞"))
            add(Pair(Int.MAX_VALUE, "∞"))
        }.also { check(it, Locale("ru","RU")) }
    }

    private fun check(pairs: List<Pair<Int, String>>, locale: Locale) {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val configuration: Configuration = context.resources.configuration
        configuration.setLocale(locale)
        val resources: Resources = context.createConfigurationContext(configuration).resources
        val formatter = CountTextFormatter(resources)

        pairs.forEach { pair ->
            val result = formatter.formatCountToText(pair.first)
            assertEquals("error in pair <${pair.first}, ${pair.second}>", pair.second, result)
        }
    }
}
