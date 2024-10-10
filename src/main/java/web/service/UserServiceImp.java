package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Car> getAllCars() {
        return userDao.getAllCars();
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        return getAllCars().stream().limit(count).collect(Collectors.toList());
    }

}
