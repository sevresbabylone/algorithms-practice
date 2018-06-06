package com.example.lowarray;

// lowArray.java
// demonstrates array class with low-level interface

public class LowArray {
    private long[] a;

    public LowArray(int size) { // constructor
        a = new long[size]; // create array
    }
    public void setElem(int index, long value) {
        a[index] = value;
    }
    public long getElem(int index) {
        return a[index];
    }
}

