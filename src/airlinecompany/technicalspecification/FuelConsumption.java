package airlinecompany.technicalspecification;

/**
 * fuel consumption in liters per hour
 */
public class FuelConsumption extends GeneralMeasureValue {
    private static final long serialVersionUID = -6797846879375056674L;

    public FuelConsumption(int fuelValue) {
        super(fuelValue);
    }

    public FuelConsumption() {
        super(0);
    }


    // return a value of fuel consumption in liters per hour
    @Override
    public int getMeasureValueInInt() {
        return measureValue;
    }

    @Override
    public String getMeasureValueInString() {
        return this.measureValue + " liters / hr";
    }


    @Override
    public void setMeasureIntValue(int fuelValue) {
        super.measureValue = fuelValue;
    }

    @Override
    public String toString() {
        return "fuel consumption = " + measureValue + " liters / hr";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof FuelConsumption)) {
            return false;
        }

        FuelConsumption other = (FuelConsumption) obj;
        return (this.measureValue == other.measureValue);
    }
}
