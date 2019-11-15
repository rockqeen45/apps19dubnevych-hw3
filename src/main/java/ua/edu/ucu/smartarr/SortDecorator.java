package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        BaseArray sortArr = new BaseArray(smartArray.toArray());

        for (int i = 0; i < sortArr.size(); i++) {
            Object min = sortArr.get(i);
            int minIndex = i;
            for (int j = i + 1; j < sortArr.size(); j++) {
                if (cmp.compare(min, sortArr.get(j)) > 0) {
                    min = sortArr.get(j);
                    minIndex = j;
                }
            }
            Object temp = sortArr.get(i);
            sortArr.set(i, min);
            sortArr.set(minIndex, temp);
        }
        this.smartArray = sortArr;
    }
}
