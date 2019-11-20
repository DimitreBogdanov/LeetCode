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
    public void isPalindromeTest(){
        assertEquals(false, Easy.isPalindrome(-5));
        assertEquals(false, Easy.isPalindrome(-121));

        assertEquals(true, Easy.isPalindrome(1));
        assertEquals(true, Easy.isPalindrome(0));
        assertEquals(true, Easy.isPalindrome(121));
        assertEquals(true, Easy.isPalindrome(1221));
        assertEquals(true, Easy.isPalindrome(12344321));
        assertEquals(true, Easy.isPalindrome(1234321));

        assertEquals(false, Easy.isPalindrome(12));
        assertEquals(false, Easy.isPalindrome(1222));
        assertEquals(false, Easy.isPalindrome(123456));
        assertEquals(false, Easy.isPalindrome(123455432));
        assertEquals(false, Easy.isPalindrome(1234554));
    }

}
