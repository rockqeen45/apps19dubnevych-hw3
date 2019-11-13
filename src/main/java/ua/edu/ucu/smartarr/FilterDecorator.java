package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        BaseArray filterArr = new BaseArray(new Object[0]);

        for (int i = 0; i < smartArray.size(); i++) {
            if (pr.test(smartArray.get(i))){
                filterArr.add(smartArray.get(i));
            }
        }
        this.smartArray = filterArr;
    }
}
