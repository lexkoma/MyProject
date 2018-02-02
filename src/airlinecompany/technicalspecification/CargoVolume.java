package airlinecompany.technicalspecification;

/**
 * Representation of a physical value of cubic meters to measure a volume.
 */
public class CargoVolume extends GeneralMeasureValue {

    public CargoVolume() {
        super(0);
    }

    public CargoVolume(int measureValue) {
        super(measureValue);
    }

    @Override
    public String getMeasureValueInString() {
        return this.measureValue + " m^3";
    }

    @Override
    public void setMeasureIntValue(int volume) {
        this.measureValue = volume;
    }

    @Override
    public int getMeasureValueInInt() {
        return measureValue;
    }

    @Override
    public String toString() {
        return "cargo volume = " + (this.measureValue) + " m^3";
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof CargoVolume)) {
            return false;
        }

        CargoVolume other = (CargoVolume) obj;
        return (this.measureValue == other.measureValue);
    }

}
