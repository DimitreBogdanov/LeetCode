package com.practice.algorithms;


public class Main {

    public static void main(String[] args) {
        for(int i: Problems.twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }
    }
}
