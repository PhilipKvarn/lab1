public class VeichleWorkshop<veichletype extends Veichle> {

    VeichleLoader<veichletype> loadedCars;

    public VeichleWorkshop(int maxCapacity) {
        this.loadedCars = new VeichleLoader<>(maxCapacity);
    }

    public void loadCar(Veichle car) {
        this.loadedCars.LoadNewVeichle(car);
    }

}
