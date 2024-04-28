package org.example;

import java.util.Iterator;


public class FibonacciIterator implements Iterator<Integer> {
    // first inital values for Fibonacci sequence
    private int current = 0;
    private int next = 1;

    @Override
    public boolean hasNext() {
        return true;  // Fibonacci sequence can be infinite, so always return true
    }

    @Override
    public Integer next() {
        int result = current;
        int temp = current + next;
        // Update current and next numbers for further calculations
        current = next;
        next = temp;
        return result;
    }
}