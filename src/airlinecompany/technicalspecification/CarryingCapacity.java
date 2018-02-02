package airlinecompany.technicalspecification;

/**
 * class represents physical value of cargo weight
 */
public class CarryingCapacity extends GeneralMeasureValue {
    private static final long serialVersionUID = -4549539249795616520L;

    public CarryingCapacity() {
        super(0);
    }

    public CarryingCapacity(int cargoValue) {
        super(cargoValue);
    }

    @Override
    public String getMeasureValueInString() {
        return this.measureValue + " tons";
    }

    @Override
    public void setMeasureIntValue(int cargoValue) {
        this.measureValue = cargoValue;
    }

    @Override
    public int getMeasureValueInInt() {
        return measureValue;
    }

    @Override
    public String toString() {
        return "weight = " + (this.measureValue) + " tons";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof CarryingCapacity)) {
            return false;
        }

        CarryingCapacity other = (CarryingCapacity) obj;
        return (this.measureValue == other.measureValue);
    }
}
