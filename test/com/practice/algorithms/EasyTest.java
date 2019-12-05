package com.practice.algorithms;

import static org.junit.Assert.*;

import com.practice.algorithms.Problems.Easy;
import org.junit.Test;

public class EasyTest {

    @Test
    public void reverseIntegerTest() {
        assertEquals(0, Easy.reverseInteger(0));

        //positive
        assertEquals(5, Easy.reverseInteger(5));
        assertEquals(5006, Easy.reverseInteger(6005));
        assertEquals(1234, Easy.reverseInteger(4321));
        assertEquals(600504321, Easy.reverseInteger(123405006));
        assertEquals(4321, Easy.reverseInteger(123400));
        assertEquals(0, Easy.reverseInteger(2147483647));

        //negative
        assertEquals(-5, Easy.reverseInteger(-5));
        assertEquals(-5006, Easy.reverseInteger(-6005));
        assertEquals(-1234, Easy.reverseInteger(-4321));
        assertEquals(-600504321, Easy.reverseInteger(-123405006));
        assertEquals(-4321, Easy.reverseInteger(-123400));
        assertEquals(0, Easy.reverseInteger(-2147483647));

        //Leetcode case
        assertEquals(-9056, Easy.reverseInteger(-65090));
    }

    @Test
    public void reverseIntegerTest2() {
        assertEquals(0, Easy.reverseIntegerNewSolution(0));

        //positive
        assertEquals(5, Easy.reverseIntegerNewSolution(5));
        assertEquals(5006, Easy.reverseIntegerNewSolution(6005));
        assertEquals(1234, Easy.reverseIntegerNewSolution(4321));
        assertEquals(600504321, Easy.reverseIntegerNewSolution(123405006));
        assertEquals(4321, Easy.reverseIntegerNewSolution(123400));
        assertEquals(0, Easy.reverseIntegerNewSolution(2147483647));

        //negative
        assertEquals(-5, Easy.reverseIntegerNewSolution(-5));
        assertEquals(-5006, Easy.reverseIntegerNewSolution(-6005));
        assertEquals(-1234, Easy.reverseIntegerNewSolution(-4321));
        assertEquals(-600504321, Easy.reverseIntegerNewSolution(-123405006));
        assertEquals(-4321, Easy.reverseIntegerNewSolution(-123400));
        assertEquals(0, Easy.reverseIntegerNewSolution(-2147483647));

        //Leetcode case
        assertEquals(-9056, Easy.reverseIntegerNewSolution(-65090));
        assertEquals(0, Easy.reverseIntegerNewSolution(1534236469));
    }


    @Test
    public void reverseIntegerTest3() {
        assertEquals(0, Easy.reverseInteger3(0));

        //positive
        assertEquals(5, Easy.reverseInteger3(5));
        assertEquals(5006, Easy.reverseInteger3(6005));
        assertEquals(1234, Easy.reverseInteger3(4321));
        assertEquals(600504321, Easy.reverseInteger3(123405006));
        assertEquals(4321, Easy.reverseInteger3(123400));
        assertEquals(0, Easy.reverseInteger3(2147483647));

        //negative
        assertEquals(-5, Easy.reverseInteger3(-5));
        assertEquals(-5006, Easy.reverseInteger3(-6005));
        assertEquals(-1234, Easy.reverseInteger3(-4321));
        assertEquals(-600504321, Easy.reverseInteger3(-123405006));
        assertEquals(-4321, Easy.reverseInteger3(-123400));
        assertEquals(0, Easy.reverseInteger3(-2147483647));

        //Leetcode case
        assertEquals(-9056, Easy.reverseInteger3(-65090));
        assertEquals(0, Easy.reverseInteger3(1534236469));
    }

    @Test
    public void isPalindromeTest(){
        assertFalse(Easy.isPalindrome(-5));
        assertFalse(Easy.isPalindrome(-121));
//        assertFalse(Easy.isPalindrome(-0));

        assertTrue(Easy.isPalindrome(1));
        assertTrue(Easy.isPalindrome(0));
        assertTrue(Easy.isPalindrome(121));
        assertTrue(Easy.isPalindrome(1221));
        assertTrue(Easy.isPalindrome(12344321));
        assertTrue(Easy.isPalindrome(1234321));

        assertFalse(Easy.isPalindrome(12));
        assertFalse(Easy.isPalindrome(1222));
        assertFalse(Easy.isPalindrome(123456));
        assertFalse(Easy.isPalindrome(123455432));
        assertFalse(Easy.isPalindrome(1234554));
    }

    @Test
    public void romanToIntTest(){

        // Base cases
        assertEquals(1, Easy.romanToInt("I"));
        assertEquals(5, Easy.romanToInt("V"));
        assertEquals(10, Easy.romanToInt("X"));
        assertEquals(50, Easy.romanToInt("L"));
        assertEquals(100, Easy.romanToInt("C"));
        assertEquals(500, Easy.romanToInt("D"));
        assertEquals(1000, Easy.romanToInt("M"));


        // Addition cases
        assertEquals(3, Easy.romanToInt("III"));
        assertEquals(15, Easy.romanToInt("VVV"));
        assertEquals(30, Easy.romanToInt("XXX"));
        assertEquals(150, Easy.romanToInt("LLL"));
        assertEquals(300, Easy.romanToInt("CCC"));
        assertEquals(1500, Easy.romanToInt("DDD"));
        assertEquals(3000, Easy.romanToInt("MMM"));


        // Subtraction cases
        assertEquals(9, Easy.romanToInt("IX"));
        assertEquals(58, Easy.romanToInt("LVIII"));
        assertEquals(4, Easy.romanToInt("IV"));
        assertEquals(1994, Easy.romanToInt("MCMXCIV"));
        assertEquals(994, Easy.romanToInt("CMXCIV"));

    }

    @Test
    public void longestCommonPrefix() {

        assertEquals("", Easy.longestCommonPrefix(new String[]{}));
        assertEquals("flower", Easy.longestCommonPrefix(new String[]{"flower"}));
        assertEquals("fl", Easy.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", Easy.longestCommonPrefix(new String[]{"fl", "anything", "something"}));
        assertEquals("start", Easy.longestCommonPrefix(new String[]{"start", "starting"}));
        assertEquals("sa", Easy.longestCommonPrefix(new String[]{"save", "say", "sa", "sample"}));

    }

}
