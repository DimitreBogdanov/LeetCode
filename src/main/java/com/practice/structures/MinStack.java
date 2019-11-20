package com.practice.structures;


//https://leetcode.com/problems/min-stack/description/
//The question is not formulated properly, you have undefined behaviour when popping, getting min, ot peeking when empty
//And it doesn't accept throwing errors.
public class MinStack {

    private class Node{
        int value;
        int min;

        Node(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    private Node[] data;
    private int capacity;
    //Size points at where the next element needs to go
    private int size;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        capacity = 50;
        data = new Node[capacity];
        size = 0;
    }

    public void push(int x) {
        if (size + 1 == capacity){
            Node[] temp = data;
            capacity = (capacity * 2) + 1;
            data = new Node[capacity];
            System.arraycopy(temp, 0, data, 0, size + 1);
        }

        if (size == 0 || x < min)
            min = x;
        data[size++] = new Node(x, min);
    }

    public void pop() {
        if (size > 0){
            size--;
        }
        if (size == 0)
            min = 0;
        else
            min = data[size - 1].min;
    }

    public int top() {
        if (size >= 0)
            return data[size - 1].value;
        return 0;
    }

    public int getMin() {
        if (size > 0)
            return data[size - 1].min;
        return 0;
    }
}