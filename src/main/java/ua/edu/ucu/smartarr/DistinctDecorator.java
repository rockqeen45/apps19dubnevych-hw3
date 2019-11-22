package ua.edu.ucu.smartarr;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).distinct().toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}