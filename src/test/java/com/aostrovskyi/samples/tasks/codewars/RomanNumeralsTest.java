package com.aostrovskyi.samples.tasks.codewars;

import junit.framework.TestCase;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest extends TestCase {



    public void testToRoman() {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(4), is("IV"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(1990), is("MCMXC"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2008), is("MMVIII"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(1666), is("MDCLXVI"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(1000), is("M"));
    }

    public void testFromRoman() {

        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("IV"), is(4));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("MCMXC"), is(1990));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("MMVIII"), is(2008));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("MDCLXVI"), is(1666));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("M"), is(1000));
    }
}