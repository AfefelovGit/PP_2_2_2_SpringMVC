package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final List<Car> cars;

    {
        cars = new ArrayList<Car>();
        cars.add(new Car("Mercedes", "Green", 1998));
        cars.add(new Car("BMW", "Black", 2001));
        cars.add(new Car("Honda", "White", 2011));
        cars.add(new Car("Tesla", "Blue", 2022));
        cars.add(new Car("Mazda", "Gray", 2015));
        cars.add(new Car("Citroen", "Yellow", 2024));
    }

    // возврат List<Car> с нужным количеством
    @Override
    public List<Car> getCars(Integer numberCar) {

        if (numberCar == null || numberCar <= 0 || numberCar >= 5) {
            return cars;
        }

        return cars.subList(0, numberCar);
    }
}
