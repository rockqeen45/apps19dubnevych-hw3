package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.function = func;
    }


    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).map(function).toArray();
    }

    @Override
    public String operationDescription() {
        return "Map " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
