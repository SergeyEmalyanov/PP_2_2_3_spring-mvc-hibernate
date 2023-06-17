package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAOImpl implements CarDAO {

    private static final List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car("Brand1", "Model1", 1));
        cars.add(new Car("Brand2", "Model2", 2));
        cars.add(new Car("Brand3", "Model3", 3));
        cars.add(new Car("Brand4", "Model4", 4));
        cars.add(new Car("Brand5", "Model5", 5));
    }

    @Override
    public List<Car> getCars(Integer quantity) {
        if (quantity == null || quantity >= cars.size()) return cars;
        else return cars.subList(0, quantity);
    }
}
