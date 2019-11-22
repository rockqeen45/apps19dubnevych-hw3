package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.comparator = cmp;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).sorted(comparator).toArray();
    }

    @Override
    public String operationDescription() {
        return "Sort " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return 0;
    }
}
