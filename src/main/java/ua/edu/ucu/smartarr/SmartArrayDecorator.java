package ua.edu.ucu.smartarr;

public abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public Object get(int i){
        return smartArray.get(i);
    }

    @Override
    public void set(int i, Object e){
        smartArray.set(i, e);
    }
}
