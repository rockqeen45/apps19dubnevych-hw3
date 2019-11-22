package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] arr;

    public BaseArray(Object[] arr) {
        if (arr != null) {
            this.arr = arr.clone();
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }

    @Override
    public String operationDescription() {
        return "Base Array functional";
    }

    @Override
    public int size() {
        return arr.length;
    }

}
