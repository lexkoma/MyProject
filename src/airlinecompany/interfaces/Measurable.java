package airlinecompany.interfaces;

/**
 * Interface represents methods of a physical values
 */
public interface Measurable {

    String getMeasureValueInString(); //return a measure value of a physical value in String type

    void setMeasureIntValue(int measureValue); //sets value in int type

    int getMeasureValueInInt(); //return a measure value of a physical value in int type.

}
