package airlinecompany.technicalspecification;

/**
 * representation of physical value of flight distance in km
 */
public class FlightRange extends GeneralMeasureValue {
    private static final long serialVersionUID = -7268552229239351278L;

    public FlightRange() {
        super(0);
    }

    public FlightRange(int distance) {
        super(distance);
    }

    @Override
    public String getMeasureValueInString() {
        return this.measureValue + " km";
    }

    @Override
    public void setMeasureIntValue(int distance) {
        this.measureValue = distance;
    }

    @Override
    public int getMeasureValueInInt() {
        return measureValue;
    }

    @Override
    public String toString() {
        return "distance = " + (this.measureValue) + " km";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof FlightRange)) {
            return false;
        }

        FlightRange other = (FlightRange) obj;
        return (this.measureValue == other.measureValue);
    }
}
