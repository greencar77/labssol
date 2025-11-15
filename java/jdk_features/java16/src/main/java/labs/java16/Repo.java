package labs.java16;

import java.util.ArrayList;
import java.util.List;

import labs.java16.domain.Car;

public class Repo {
    private List<Car> carList = new ArrayList<>();

	public Repo() {
		carList.add(new Car("Volkswagen", 200, 2000));
		carList.add(new Car("BMW", 250, 2025));
		carList.add(new Car("Peugeot", 220, 2024));
		carList.add(new Car("Jaguar", 215, 1980));
	}

    public static List<Car> getCarList() {
        Repo repo = new Repo();
        return repo.carList;
    }
}
