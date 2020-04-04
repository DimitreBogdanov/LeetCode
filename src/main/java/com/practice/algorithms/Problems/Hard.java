package com.practice.algorithms.Problems;

import java.util.ArrayList;
import java.util.List;

public class Hard {


    /**
     * Hard section
     */

    //https://leetcode.com/problems/text-justification/
    //Assumptions:
    // 0 < word.length <= maxWidth
    // words.length > 0
    // !word.contain(\s)
    //
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        List<String> temp = new ArrayList<>(words.length);
        int currentLength = 0;
        for (String word : words) {
            //Need to take into consideration adding at least 1 space in between, todo
            if (currentLength + word.length() > maxWidth){
                result.add(determineLinePack(temp, maxWidth));
            }else {
                //here we could reduce the length by keeping track of how many words we have removed
                temp = new ArrayList<>(word.length());
                temp.add(word);
            }
        }
        //At the end need to calculate

        return result;
    }

    char SPACE = ' ';
    private static String determineLinePack(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();



        return sb.toString();
    }
}
