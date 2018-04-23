package com.practice.algorithms;


import java.util.*;
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

    /**
     * Easy section
     */

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

    //https://leetcode.com/problems/find-anagram-mappings/description/
    static int[] anagramMappings(int[] A, int[] B){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[A.length];

        for (int i = 0; i < B.length; i++){
            map.put(B[i], i);
        }

        for (int i = 0; i < A.length; i++){
            result[i] = map.getOrDefault(A[i] ,-1);
        }

        return result;
    }

    //https://leetcode.com/problems/power-of-three/description/
    static boolean isPowerOfThree(int n) {
        return n == 1 || n != 0 && (n == 3 || n % 3 == 0 && isPowerOfThree(n / 3));
    }

    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    static List<Integer> findDisappearedNumbers(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= nums.length; i++){
            map.put(i, i);
        }

        for (int num: nums) {
            if (map.containsKey(num))
                map.remove(num);
        }

        return new ArrayList<>(map.values());
    }

    //https://leetcode.com/problems/first-unique-character-in-a-string/description/
    static int firstUniqChar(String s){
        //character, count
        Map<Character, Integer> map = new HashMap<>();
        //character, first index
        Map<Character, Integer> indexMap = new HashMap<>();
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char current = chars[i];
            if (!map.containsKey(current)){
                list.add(current);
                map.put(current, 1);
                indexMap.put(current, i);
            }else{
                map.put(current, map.get(current) + 1);
            }
        }

        while (list.size() > 0){
            if (map.getOrDefault(list.peek(), 0) == 1)
                return indexMap.get(list.peek());
            list.pop();
        }
        return -1;
    }

    //https://leetcode.com/problems/power-of-two/description/
    //This can be inlined in a single statement but this is more readable
    static boolean isPowerOfTwo(int n){
        if (n == 1)
            return true;
        if (n == 0)
            return false;
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }

    //https://leetcode.com/problems/reverse-vowels-of-a-string/description/
    static String reverseVowels(String s){
        if (s.trim().length() == 0)
            return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;
        boolean firstVowel = false;
        boolean secondVowel = false;
        while(i < j){
            if (firstVowel && secondVowel){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                firstVowel = false;
                secondVowel = false;
                i++;
                j--;
                continue;
            }

            if (vowels.contains(String.valueOf(chars[i])))
                firstVowel = true;
            else
                i++;

            if (vowels.contains(String.valueOf(chars[j])))
                secondVowel = true;
            else
                j--;
        }

        return new String(chars);
    }

    static int guess(int num){
        return Integer.compare(num, 1702766719);
    }

    //https://leetcode.com/problems/guess-number-higher-or-lower/description/
    //Terrible example, very little specifications
    static int guessNumber(int n){
        int low = 1;
        int high = n;
        int result, middle;
        do {
            middle = (int)(((long)high + (long)low)/2);
            result = guess(middle);
            if (result == 0)
                return middle;
            if (result < 0)
                low = middle + 1;
            else
                high = middle - 1;
        }while(high >= low);

        return middle;
    }

    /**
     * Medium section
     */

    //https://leetcode.com/problems/encode-and-decode-tinyurl/description/
    //See Codec class

    //todo
    //https://leetcode.com/problems/longest-absolute-file-path/description/
    static int lengthLongestPath(String input) {
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
    static List<String> letterCombinations(String digits) {
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
    static List<String> generatePerenthesis(int n){
        return null;
    }

    //https://leetcode.com/problems/powx-n/
    static double myPow(double x, int n){
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
    static List<Interval> merge(List<Interval> intervals){
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
    static int numIslands(char[][] grid){
        int result = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (String.valueOf(grid[i][j]).equals("1")){
                    result++;
                    dfs(grid, i, j);
                }
        return result;
    }

    static void dfs(char[][] grid, int i, int j){
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




    /**
     * Hard section
     */

}
