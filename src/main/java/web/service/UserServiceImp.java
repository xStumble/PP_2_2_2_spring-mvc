package web.service;

import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImp implements UserService {

    private final UserDao userDao = new UserDaoImp();

    @Override
    public List<Car> getAllCars() {
        return userDao.getAllCars();
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        List<Car> cars = getAllCars();
        if (count < 0) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }

}
