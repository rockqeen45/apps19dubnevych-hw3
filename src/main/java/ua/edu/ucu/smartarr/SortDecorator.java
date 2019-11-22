package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.stream.Stream;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray, smartArray.operationDescription());
        Object[] srt = Stream.of(smartArray.toArray()).sorted(cmp).toArray();
        this.smartArray = new BaseArray(srt);

    }

    @Override
    public String operationDescription() {
        return "Sort " + description;
    }
}
