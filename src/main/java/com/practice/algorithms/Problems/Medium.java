package com.practice.algorithms.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Medium {


    /**
     * Medium section
     */

    //https://leetcode.com/problems/encode-and-decode-tinyurl/description/
    //See Codec class

    //todo
    //https://leetcode.com/problems/longest-absolute-file-path/description/
    public static int lengthLongestPath(String input) {
        if (input == null || input.trim().length() == 0)
            return 0;

        //Can be more optimized to use stringbuilder or something rather than string which is immutable
        while (input.length() > 0){

        }

        return 0;
    }

    static List<List<String>> mapping = new ArrayList<>();
    static {
        mapping.add(new ArrayList<>());
        mapping.add(new ArrayList<>());
        mapping.add(Arrays.asList("a", "b", "c"));
        mapping.add(Arrays.asList("d", "e", "f"));
        mapping.add(Arrays.asList("g", "h", "i"));
        mapping.add(Arrays.asList("j", "k", "l"));
        mapping.add(Arrays.asList("m", "n", "o"));
        mapping.add(Arrays.asList("p", "q", "r", "s"));
        mapping.add(Arrays.asList("t", "u", "v"));
        mapping.add(Arrays.asList("w", "x", "y", "z"));
    }

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        List<List<String>> selectedDigits = new ArrayList<>();
        char[] charDigits = digits.toCharArray();
        for (char c: charDigits){
            if (!Character.isDigit(c) || Integer.parseInt(String.valueOf(c)) < 2)
                continue;
            selectedDigits.add(mapping.get(Integer.parseInt(String.valueOf(c))));
        }
        if (selectedDigits.size() == 0)
            return new ArrayList<>();
        combination(combinations, selectedDigits, 0, "");
        return combinations;
    }

    private static void combination(List<String> combinations, List<List<String>> digits, int position, String currentString) {
        if (position == digits.size() - 1){
            for (String s: digits.get(position)){
                combinations.add(currentString + s);
            }
            return;
        }
        for (String s: digits.get(position)){
            combination(combinations, digits, position + 1, currentString + s);
        }
    }

    //todo
    //https://leetcode.com/problems/generate-parentheses/description/
    public static List<String> generatePerenthesis(int n){
        return null;
    }

    //https://leetcode.com/problems/powx-n/
    public static double myPow(double x, int n){
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0){
            x = 1 / x;
            n = -n;
        }
        double accumulation = x;
        while(n > 1){
            accumulation *= x;
            n--;
        }
        return accumulation;
    }

    private static class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.start == o.start && this.end == o.end)
                return 0;
            if (this.start < o.start || (this.start == o.start && this.end < o.end))
                return -1;
            return 1;
        }
    }

    //https://leetcode.com/problems/merge-intervals/description/
    public static List<Interval> merge(List<Interval> intervals){
        Collections.sort(intervals);
        if (intervals.size() == 0)
            return intervals;
        List<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            Interval next = intervals.get(i);
            if (current.end >= next.start && current.start <= next.start){
                current = new Interval(current.start, Math.max(current.end, next.end));
            }else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result;
    }

    //https://leetcode.com/problems/number-of-islands/description/
    public static int numIslands(char[][] grid){
        int result = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (String.valueOf(grid[i][j]).equals("1")){
                    result++;
                    dfs(grid, i, j);
                }
        return result;
    }

    public static void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return;
        if (String.valueOf(grid[i][j]).equals("1")){
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
