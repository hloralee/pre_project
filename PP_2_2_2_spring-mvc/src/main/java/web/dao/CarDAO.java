package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("Tesla", "Model 3", 2020));
        cars.add(new Car("Tesla", "Model Z", 2019));
        cars.add(new Car("Tesla", "Model Y", 2022));
        cars.add(new Car("Tesla", "Model X", 2023));
        cars.add(new Car("Tesla", "Model S", 2018));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> show(int index) {
        return cars.stream().limit(index).collect(Collectors.toList());
    }
}
