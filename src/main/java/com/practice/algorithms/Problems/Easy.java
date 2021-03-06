package com.practice.algorithms.Problems;

import java.util.*;

public class Easy {

    /**
     * Easy section
     */

    //TODO
    //A is an array of N values where A[index] represent the height of a tree. The heights of the trees must always be varying (up, down, up OR down, up, down). Tree height is between 2 and 1000. N is between 1 and 100, 000.
    //If the pattern is invalid, a tree must be shortened to make it valid. Write a function that return the number of tress that must be shortened.
    //Ex: [5, 4, 3, 2, 6]
    //Here, the function would return 1 because 4 can be shorted to 2 to make it valid.
    //This is not from leetcode

    private final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    public static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    private static final Map<Character, Integer> romanToIntMap = new HashMap<>();
    static{
        romanToIntMap.put('M', 1000);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('I', 1);
    }

    public static int maxSubArray(int[] nums){
        if (nums.length == 1)
            return nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++){
            int localTotal = nums[i];
            for (int j = i+1; j < nums.length; j++){
                localTotal += nums[j];
                if (localTotal > max)
                    max = localTotal;
            }
        }
        return max;
    }

    //https://leetcode.com/problems/search-insert-position/
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
    //Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Search Insert Position.
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target || nums[i] > target)
                return i;
        return nums.length;
    }

    //https://leetcode.com/problems/implement-strstr/
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
    //Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Implement strStr().
    //This is dumb....
    public static int strStr(String haystack, String needle){
        return haystack.indexOf(needle);
    }

    //https://leetcode.com/problems/remove-element/submissions/
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
    //Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Element.
    public static int removeElement(int[] nums, int val) {
        int availableIndex = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[availableIndex++] = nums[i];
        return availableIndex;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    //Need to keep track of the next available index, and keep pushing there
    //Runtime: 1 ms, faster than 97.83% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 37.7 MB, less than 99.47% of Java online submissions for Remove Duplicates from Sorted Array.
    public static int removeDuplicates2(int[] nums){
        if (nums.length < 2)
            return nums.length;
        int availableIndex = 1;
        int lastUniqueNumber = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != lastUniqueNumber){
                lastUniqueNumber = nums[i];
                nums[availableIndex++] = nums[i];
            }
        }
        return availableIndex;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    //Runtime: 51 ms, faster than 5.17% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 43.6 MB, less than 5.32% of Java online submissions for Remove Duplicates from Sorted Array.
    public static int removeDuplicates(int[] nums){
        if (nums.length < 2)
            return nums.length;
        int length = nums.length;
        for (int i = 1; i < length ;){
            if (nums[i] == nums[i-1]){
                shift(nums, i);
                length--;
            }else{
                i++;
            }
        }
        return length;
    }

    private static void shift(int[] nums, int index){
        for (int i = index; i < nums.length - 1; i++){
            nums[i] = nums[i+1];
        }
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public static class ListNode{
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
    //https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 39.7 MB, less than 16.16% of Java online submissions for Merge Two Sorted Lists.
    //The key is that you keep a reference to the beginning, which really is just a dummy, from there on the next is start, and you return next at the end.
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null)
            return null;
        ListNode result = new ListNode(0);
        ListNode end = result;
        do{
            if (l1 == null){
                end.next = l2;
                break;
            }else if (l2 == null) {
                end.next = l1;
                break;
            }else if (l1.val <= l2.val){
                end.next = l1;
                l1 = l1.next;
            }else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        } while(true);
        return result.next;
    }

    //https://leetcode.com/problems/longest-common-prefix/
    //Runtime: 2 ms, faster than 16.41% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 37.5 MB, less than 86.55% of Java online submissions for Longest Common Prefix.
    public static String longestCommonPrefix(String[] strs){
        if (strs.length == 0)
            return "";
        String str = strs[0];
        if (strs.length == 1)
            return str;
        String currentPrefix = "";

        for (int i = 0; i < str.length(); i++){
            currentPrefix = str.substring(0, i + 1);
            for (int j = 1; j < strs.length; j++){
                if (!strs[j].startsWith(currentPrefix))
                    return currentPrefix.substring(0, i);
            }
        }

        return currentPrefix;
    }

    //https://leetcode.com/problems/roman-to-integer/
    //Runtime: 5 ms, faster than 59.36% of Java online submissions for Roman to Integer.
    //Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Roman to Integer.
    public static int romanToInt(String s){
        if (s.length() <= 0)
            return 0;
        if (s.length() == 1)
            return romanToIntMap.getOrDefault(s.charAt(0), 0);
        int total = 0;
        char[] numerals = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--){
            char currentChat = numerals[i];
            int numberValue = romanToIntMap.getOrDefault(currentChat, 0);
            if (numberValue == 0)
                continue;

            if ( i > 0 ){
                int nextNumber = romanToIntMap.getOrDefault(numerals[i - 1], 0);
                if (nextNumber < numberValue){
                    total += (numberValue - nextNumber);
                    i--;
                }else {
                    total += numberValue;
                }
            }else {
                total += numberValue;
            }
        }
        return total;
    }

    //https://leetcode.com/problems/palindrome-number/
    //Runtime: 7 ms, faster than 72.36% of Java online submissions for Palindrome Number.
    //Memory Usage: 36.2 MB, less than 5.02% of Java online submissions for Palindrome Number.
    //Could be improved by not looping twice
    public static boolean isPalindrome(int x){
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        int[] buffer = new int[Easy.stringSize(x)];
        int i = 0;
        for(;;){
            int remainder = x % 10;
            x = x/10;

            buffer[i++] = remainder;

            if (x == 0)
                break;
        }

        for (int j = 0; j < buffer.length/2; j++){
            if (buffer[j] != buffer[buffer.length - j - 1])
                return false;
        }
        return true;
    }



    //https://leetcode.com/problems/reverse-integer/
    //Completed
    //Runtime: 2 ms, faster than 24.62% of Java online submissions for Reverse Integer.
    //Memory Usage: 34.2 MB, less than 5.55% of Java online submissions for Reverse Integer.
    public static int reverseInteger(int x){
        try{
            boolean negative = false;
            char[] inputIntegerChars;
            if (x < 0){
                negative = true;
                inputIntegerChars = Integer.toString(x).substring(1).toCharArray();
            }else {
                inputIntegerChars = Integer.toString(x).toCharArray();
            }
            char[] outputIntegerChars = new char[inputIntegerChars.length];
            int nonZeroIndex = -1;
            for (int i = 0; i < inputIntegerChars.length; i++){
                if (!String.valueOf(inputIntegerChars[i]).equals("0"))
                    nonZeroIndex = i;
                outputIntegerChars[inputIntegerChars.length - i - 1] = inputIntegerChars[i];
            }
            String outputString = new String(outputIntegerChars);
            int result;
            if (nonZeroIndex > 0 && nonZeroIndex < outputString.length() - 1)
                result = Integer.parseInt(outputString.substring(outputString.length() - nonZeroIndex - 1));
            else
                result = Integer.parseInt(outputString);
            if (negative)
                return (result * -1);
            return result;
        } catch (NumberFormatException nfe){
            return 0;
        }
    }
    //https://leetcode.com/problems/reverse-integer/
    //Not working yet
    public static int reverseIntegerNewSolution(int x){
        try{
            if (x == 0)
                return x;
            boolean negative = false;
            if (x < 0) {
                negative = true;
                x*= -1;
            }
            boolean numberStart = false;
            long finalNum = 0;
            for (;;){
                int numberSize = Easy.stringSize(x);
                int multiplier = (int)Math.pow(10, numberSize - 1);
                int remainder = x % 10;
                x = x / 10;
                if (remainder == 0 && !numberStart)
                    continue;
                if (remainder != 0 && !numberStart){
                    numberStart = true;
                }
                finalNum += remainder * multiplier;
                if (finalNum < 0)
                    return 0;
                if ( x == 0 )
                    break;
            }
            //return Integer.parseInt(finalNum) * (negative? -1 : 1);
            if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE)
                return 0;
            return negative ? -1 * (int)finalNum: (int)finalNum;
        } catch ( NumberFormatException nfe){
            return 0;
        }
    }
    //https://leetcode.com/problems/reverse-integer/
    //Completed
    //Runtime: 2 ms, faster than 24.62% of Java online submissions for Reverse Integer.
    //Memory Usage: 33.7 MB, less than 11.66% of Java online submissions for Reverse Integer.
    public static int reverseInteger3(int x){
        try{
            boolean negative = false;
            char[] inputIntegerChars;
            if (x < 0){
                negative = true;
                inputIntegerChars = Integer.toString(x).substring(1).toCharArray();
            }else {
                inputIntegerChars = Integer.toString(x).toCharArray();
            }
            for (int i = 0; i < inputIntegerChars.length/2; i++){
                char temp = inputIntegerChars[i];
                inputIntegerChars[i] = inputIntegerChars[inputIntegerChars.length -i -1];
                inputIntegerChars[inputIntegerChars.length - i - 1] = temp;
            }
            return negative? -1* Integer.parseInt(new String(inputIntegerChars)): Integer.parseInt(new String(inputIntegerChars));
//            char[] outputIntegerChars = new char[inputIntegerChars.length];
//            int nonZeroIndex = -1;
//            for (int i = 0; i < inputIntegerChars.length; i++){
//                if (!String.valueOf(inputIntegerChars[i]).equals("0"))
//                    nonZeroIndex = i;
//                outputIntegerChars[inputIntegerChars.length - i - 1] = inputIntegerChars[i];
//            }
//            String outputString = new String(outputIntegerChars);
//            int result;
//            if (nonZeroIndex > 0 && nonZeroIndex < outputString.length() - 1)
//                result = Integer.parseInt(outputString.substring(outputString.length() - nonZeroIndex - 1));
//            else
//                result = Integer.parseInt(outputString);
//            if (negative)
//                return (result * -1);
//            return result;
        } catch (NumberFormatException nfe){
            return 0;
        }
    }

    //https://leetcode.com/problems/valid-parentheses/description/
    //todo resubmit new solution
    public static boolean isValid(String s) {
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
    public static int[] plusOne(int[] digits) {
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
    public static boolean judgeCircle(String moves) {
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
    public static int islandPerimeter(int[][] grid) {
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
    public static String solution(String s, int k) {
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
    public static int[] anagramMappings(int[] A, int[] B){
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
    public static boolean isPowerOfThree(int n) {
        return n == 1 || n != 0 && (n == 3 || n % 3 == 0 && isPowerOfThree(n / 3));
    }

    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    public static List<Integer> findDisappearedNumbers(int[] nums) {

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
    public static int firstUniqChar(String s){
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
    public static boolean isPowerOfTwo(int n){
        if (n == 1)
            return true;
        if (n == 0)
            return false;
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }

    //https://leetcode.com/problems/reverse-vowels-of-a-string/description/
    public static String reverseVowels(String s){
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

    public static int guess(int num){
        return Integer.compare(num, 1702766719);
    }

    //https://leetcode.com/problems/guess-number-higher-or-lower/description/
    //Terrible example, very little specifications
    public static int guessNumber(int n){
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

    //https://leetcode.com/problems/two-sum/
    //Runtime: 1 ms, faster than 99.89% of Java online submissions for Two Sum.
    //Memory Usage: 39.9 MB, less than 5.65% of Java online submissions for Two Sum.
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> seen = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (seen.containsKey(diff)){
                result[0] = seen.get(diff);
                result[1] = i;
                break;
            }
            seen.put(num, i);
        }
        return result;
    }

}
