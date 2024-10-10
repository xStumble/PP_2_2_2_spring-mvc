package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final List<Car> cars = List.of(
            new Car("Dodge", "Charger", 1969),
            new Car("Porsche", "Panamera", 2012),
            new Car("Ford", "Focus", 2013),
            new Car("Audi", "R8", 2010),
            new Car("Toyota", "Camry", 2008)
    );

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}
