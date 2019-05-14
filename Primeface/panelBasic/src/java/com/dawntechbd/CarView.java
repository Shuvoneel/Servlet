package com.dawntechbd;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CarView {

    private List<Car> cars;

    public List<Car> getCars() {
        cars = new ArrayList<>();
        cars.add(new Car("Hundai", "Manufactured by Hundai Corporation"));
        cars.add(new Car("BMW", "Manufactured by BMW Corporation"));
        cars.add(new Car("Marcedes Benz", "Manufactured by Marcedes Corporation"));
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
