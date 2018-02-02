package airlinecompany.technicalspecification;

/**
 * Represents its physical value of speed in kilometers per hour
 */
public class FlightSpeed extends GeneralMeasureValue {
    private static final long serialVersionUID = -6250503335050233818L;

    public FlightSpeed(int speedValue) {
        super(speedValue);
    }


    public FlightSpeed() {
        super(0);
    }

    @Override
    public int getMeasureValueInInt() {
        return measureValue;
    }

    @Override
    public String getMeasureValueInString() {
        return this.measureValue + " km/h";
    }

    @Override
    public void setMeasureIntValue(int speedValue) {
        this.measureValue = speedValue;
    }


    @Override
    public String toString() {
        return "speed = " + (this.measureValue) + " km/h";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof FlightSpeed)) {
            return false;
        }

        FlightSpeed other = (FlightSpeed) obj;
        return (this.measureValue == other.measureValue);
    }
}
