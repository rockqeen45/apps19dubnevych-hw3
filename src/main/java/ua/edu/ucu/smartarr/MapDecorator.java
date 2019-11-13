package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        BaseArray mapArr = new BaseArray(new Object[0]);

        for (int i = 0; i < smartArray.size(); i++) {
            Object temp = func.apply(smartArray.get(i));
            mapArr.add(temp);
        }
        this.smartArray = mapArr;
    }
}
