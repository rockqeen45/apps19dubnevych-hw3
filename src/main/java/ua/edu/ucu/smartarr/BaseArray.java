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
        return Arrays.copyOf(this.arr, this.arr.length);
    }

    @Override
    public String operationDescription() {
        return "Base Array functional";
    }

    @Override
    public int size() {
        return arr.length;
    }

    public Object get(int i) {
        return arr[i];
    }

    @Override
    public void set(int i, Object e) {
        arr[i] = e;
    }

    public void add(Object e) {
        Object[] newArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = e;
        arr = newArr;
    }

}
