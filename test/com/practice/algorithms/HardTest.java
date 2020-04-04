package com.practice.algorithms;

import static org.junit.Assert.*;

import com.practice.algorithms.Problems.Hard;
import org.junit.Test;

public class HardTest {

    @Test
    public void textJustificationTest() {
        assertArrayEquals(
                new String[]{
                        "This    is    an",
                        "example  of text",
                        "justification.  "
                },
                Hard.fullJustify(
                    new String[]{"This", "is", "an", "example", "of", "text", "justification."},16
                ).toArray()
        );
        assertArrayEquals(
                new String[]{
                        "What   must   be",
                        "acknowledgment  ",
                        "shall be        "
                },
                Hard.fullJustify(
                    new String[]{"What","must","be","acknowledgment","shall","be"},16
                ).toArray()
        );
        assertArrayEquals(
                new String[]{
                        "Science  is  what we",
                        "understand      well",
                        "enough to explain to",
                        "a  computer.  Art is",
                        "everything  else  we",
                        "do                  "
                },
                Hard.fullJustify(
                    new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a",
                        "computer.","Art","is","everything","else","we","do"},16
                ).toArray()
        );
    }
}
