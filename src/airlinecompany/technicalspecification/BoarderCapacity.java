package airlinecompany.technicalspecification;

/**
 * represents  a number of passengers
 */
public class BoarderCapacity extends GeneralMeasureValue {


    private static final long serialVersionUID = -4706163980540502592L;

    public BoarderCapacity() {
        super(0);
    }

    public BoarderCapacity(int passengerValue) {
        super(passengerValue);
    }

    @Override
    public String getMeasureValueInString() {
        return measureValue + " passengers";
    }

    @Override
    public void setMeasureIntValue(int passengerValue) {
        this.measureValue = passengerValue;
    }

    @Override
    public int getMeasureValueInInt() {
        return measureValue;
    }

    @Override
    public String toString() {
        return "passenger capacity = " + (this.measureValue) + " persons";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof BoarderCapacity)) {
            return false;
        }

        BoarderCapacity other = (BoarderCapacity) obj;
        return (this.measureValue == other.measureValue);
    }
}
