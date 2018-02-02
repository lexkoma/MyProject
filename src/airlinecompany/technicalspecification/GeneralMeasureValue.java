package airlinecompany.technicalspecification;

import airlinecompany.interfaces.Measurable;

import java.io.Serializable;

/**
 * Class represents is a root of physical quantities classes
 * hierarchy, which describes an abstract measure value
 */
public abstract class GeneralMeasureValue implements Measurable, Comparable<Object>, Serializable{
    private static final long serialVersionUID = 6905531713991803421L;
    protected int measureValue;

    public abstract String getMeasureValueInString(); // returns string value of object

    public abstract void setMeasureIntValue(int measureValue);

    public abstract int getMeasureValueInInt(); //returns int value of a measureValue


    public GeneralMeasureValue(int measureValue) {
        this.measureValue = measureValue;
    }


    @Override
    public int compareTo(Object o) {
        GeneralMeasureValue other = (GeneralMeasureValue) o;
        return (this.getMeasureValueInInt() - other.getMeasureValueInInt());
    }
}
