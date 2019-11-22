package ua.edu.ucu.smartarr;


public class DistinctDecorator extends SmartArrayDecorator {


    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray, smartArray.operationDescription());
        BaseArray distinctArr = new BaseArray(new Object[0]);

        for (int i = 0; i < smartArray.size(); i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < distinctArr.size(); j++) {
                if (smartArray.get(i).equals(distinctArr.get(j))) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (!hasDuplicate) {
                distinctArr.add(smartArray.get(i));
            }
        }
        this.smartArray = distinctArr;
    }

    @Override
    public String operationDescription() {
        return "Distinct " + description;
    }
}