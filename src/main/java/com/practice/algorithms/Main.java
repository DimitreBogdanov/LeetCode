package com.practice.algorithms;


import com.practice.algorithms.Problems.Easy;

public class Main {

    public static void main(String[] args) {
        System.out.println(palindromeInteger(1));
    }

    static boolean palindromeInteger(int x){
        if (x <= -0)
            return false;
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
}
