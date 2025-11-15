package labs.java16.solution;

import java.util.List;
import java.util.Objects;

import labs.java16.Repo;
import labs.java16.domain.Car;

public class Main {
	public static void main(String[] args) {
		output();
		hashCodes();
	}

	private static void output() {
		List<Car> cars = Repo.getCarList();

		Car skoda = new Car("Skoda", 190, 1990);
		cars.add(skoda);
		System.out.println(skoda);

		cars.forEach(c -> System.out.println(c.brand() + " " + c.year() + " " + c.maxSpeed()));
	}

	private static void hashCodes() {
		System.out.println(new Car("Skoda", 190, 1990).hashCode());
		System.out.println(new Car("Skoda", 190, 1990).hashCode());

		Car seat = new Car("Seat", 221, 2015);
		System.out.println(seat.hashCode());
		System.out.println(Objects.hash(seat));
	}
}
