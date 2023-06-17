package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String carBrand;
    private String model;
    private int series;

    public Car() {
    }
    public Car(String carBrand, String model, int series) {
        this.carBrand = carBrand;
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
