package com.practice.algorithms;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    //todo resubmit new solution
    static boolean isValid(String s) {
        Stack<Character> parenthesis = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        for (Character c : s.toCharArray()) {
            if (c.toString().equals("(") || c.toString().equals("{") || c.toString().equals("[")) {
                parenthesis.push(c);
                continue;
            }
            if (parenthesis.empty())
                return false;
            String current = parenthesis.peek().toString();
            if (!current.equals(map.getOrDefault(current, "")))
                return false;
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

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if(digits[i] > 9)
                digits[i] = 0;
            else
                return digits;
        }

        //If you have a carry-over left at the end, unfortunately means you have to expand by one on the left
        //Create new array, start with the carry-over and copy the rest
        //Can be done by just creating a new array and setting the first element to 1, defaults rest to 0 anyways
        if(digits[0] == 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }else {
            return digits;
        }
    }

    //https://leetcode.com/problems/judge-route-circle/description/
    //Not defined properly, what does it mean to make a circle
    //Apparently as long as the end result is (0,0) it's good enough
    static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (Character move:moves.toCharArray()) {
            switch (move.toString()) {
                case "U":
                    y++;
                    break;
                case "D":
                    y--;
                    break;
                case "R":
                    x++;
                    break;
                case "L":
                    x--;
                    break;
                default:
                    return false;
            }
        }
        return x == 0 && y == 0;
    }
}
