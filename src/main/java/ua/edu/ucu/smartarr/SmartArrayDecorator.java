package ua.edu.ucu.smartarr;

public abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;
    protected String description;

    public SmartArrayDecorator(SmartArray smartArray, String description) {
        this.smartArray = smartArray;
        this.description = description;
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
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
