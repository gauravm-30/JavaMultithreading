package com.multithreading.PrintAlternateNumber.Approach2;

public class SharedValue {
    private volatile int value; //make this are volatile so that other thread have visibility

    public SharedValue(int value) {
        this.value = value;
    }

    public  int getValue() {
        return value;
    }

    public  void setValue(int value) {
        this.value = value;
    }
}

