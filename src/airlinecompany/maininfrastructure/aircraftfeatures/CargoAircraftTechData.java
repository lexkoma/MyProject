package airlinecompany.maininfrastructure.aircraftfeatures;

import airlinecompany.interfaces.UniqueAircraftBehavior;
import airlinecompany.technicalspecification.CargoVolume;

import java.io.Serializable;

public class CargoAircraftTechData implements Serializable, UniqueAircraftBehavior {
    private static final long serialVersionUID = 5164772108121031860L;

    private CargoVolume cargoVolume; // cargo size, which can transport aircraft

    private boolean canTransportAnimals; // opportunity to transport animals

    public CargoAircraftTechData(CargoVolume cargoVolume, boolean canTransportAnimals) {
        this.cargoVolume = cargoVolume;
        this.canTransportAnimals = canTransportAnimals;
    }


    public CargoAircraftTechData() {
        this.cargoVolume = new CargoVolume();
        this.canTransportAnimals = false;
    }

    public CargoVolume getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(CargoVolume cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public boolean canTransportAnimals() {
        return canTransportAnimals;
    }

    public void setCanTransportAnimals(boolean canTransportAnimals) {
        this.canTransportAnimals = canTransportAnimals;
    }

    @Override
    public String toString() {
        return ((this.cargoVolume.toString()) + "\n" + "can also transport animals = "
                + (this.canTransportAnimals));
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof CargoAircraftTechData)) {
            return false;
        }

        CargoAircraftTechData other = (CargoAircraftTechData) obj;
        return ((this.canTransportAnimals == other.canTransportAnimals)
                && (this.cargoVolume.equals(other.cargoVolume)));
    }


}
