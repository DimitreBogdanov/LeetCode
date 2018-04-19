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

    //https://leetcode.com/problems/island-perimeter/description/
    static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 0)
                    continue;
                if (i == 0)
                    perimeter++;
                if (i == grid.length -1)
                    perimeter++;
                if (j == 0)
                    perimeter++;
                if (j == grid[i].length - 1)
                    perimeter++;
                if (i > 0 && grid[i-1][j] == 0)
                    perimeter++;
                if (j > 0 && grid[i][j-1] == 0)
                    perimeter++;
                if (i < grid.length - 1 && grid[i+1][j] == 0)
                    perimeter++;
                if (j < grid[i].length - 1 && grid[i][j+1] == 0)
                    perimeter++;
            }
        }
        return perimeter;
    }


    //Test
    static String solution(String s, int k) {
        StringBuilder sb = new StringBuilder();
        //This is somewhat necessary to get the length of the string without dashes, not very efficient though
        String newString = s.replaceAll("-", "");

        int outstanding = newString.length() % k;
        int groupsGoal = newString.length() / k;
        int totalGroups = 0;
        int currentGroup = 0;

        char[] characters = newString.toCharArray();
        int i = 0;
        for (; i < outstanding && i < characters.length; i++){
            if (String.valueOf(characters[i]).equals("-")) {
                outstanding++;
                continue;
            }
            sb.append(String.valueOf(characters[i]).toUpperCase());
        }

        if (outstanding != 0 && i < characters.length)
            sb.append("-");

        while(i < characters.length){
            if (currentGroup == k && totalGroups != groupsGoal){
                totalGroups++;
                sb.append("-");
                currentGroup = 0;
            }else {
                currentGroup++;
                sb.append(String.valueOf(characters[i]).toUpperCase());
                i++;
            }
        }

        return sb.toString();
    }
}
