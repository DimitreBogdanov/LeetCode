package com.practice.algorithms;


import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problems {

    private Problems() {
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    //https://leetcode.com/problems/valid-parentheses/description/
    static boolean isValid(String s) {
        Stack<Character> parenthesis = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c.toString().equals("(") || c.toString().equals("{") || c.toString().equals("[")) {
                parenthesis.push(c);
                continue;
            }
            if (parenthesis.empty())
                return false;
            switch (c.toString()) {
                case ")":
                    if (!parenthesis.peek().toString().equals("(")) {
                        return false;
                    }
                    break;
                case "}":
                    if (!parenthesis.peek().toString().equals("{")) {
                        return false;
                    }
                    break;
                case "]":
                    if (!parenthesis.peek().toString().equals("[")) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            parenthesis.pop();
        }

        return parenthesis.empty();
    }

    //https://leetcode.com/problems/plus-one/description/
    static int[] plusOne(int[] digits) {
        //Assume it is a non-empty array
        //Assume non-negative integer
        //Single digit for each element
        //No leading 0's except 0 itself
        //When put all together, represents a whole number
        //Need to add 1 to that number

        //Can remove the first and just add 1 to the starting element
        boolean carry = false;
        boolean first = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (first){
                digit++;
                first = false;
            }

            if (carry) {
                digit++;
                carry = false;
            }

            if(digit > 9) {
                digit = digit - 10;
                carry = true;
            }
            digits[i] = digit;
        }

        //If you have a carry-over left at the end, unfortunately means you have to expand by one on the left
        //Create new array, start with the carry-over and copy the rest
        //Can be done by just creating a new array and setting the first element to 1, defaults rest to 0 anyways
        if(carry){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }else {
            return digits;
        }
    }

    //https://leetcode.com/problems/judge-route-circle/description/
    //Not defined properly, what does it mean to make a circle
    static boolean judgeCircle(String moves) {
        for (Character move:moves.toCharArray()) {
            switch (move.toString()) {
                case "U":
                    break;
                case "D":
                    break;
                case "R":
                    break;
                case "L":
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
