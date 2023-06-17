package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.model.Car;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private CarDAO carDao;
    @Autowired
    public CarServiceImpl(CarDAO carDao) {
        this.carDao = carDao;
    }
    @Override
    public List<Car> getCars(Integer quantity) {
        return carDao.getCars(quantity);
    }
}
