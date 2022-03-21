package Homework4.Car;

import Homework4.Enums.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Car {

        private ColorsCar color;
        private final Enum model;
        private Enum wheelSize;
        private final Enum engineCapacity;
        private Set<OptionsCar> options;

        public Car(ColorsCar color,
                   Enum model,
                   Enum wheelSize,
                   Enum engineCapacity) {
            this.color = color;
            this.model = model;
            this.wheelSize = wheelSize;
            this.engineCapacity = engineCapacity;
            this.options = new HashSet<>();
        }

        public Car(ColorsCar color,
                   Enum model,
                   Enum wheelSize,
                   Enum engineCapacity,
                   Set<OptionsCar> options) {
            this.color = color;
            this.model = model;
            this.wheelSize = wheelSize;
            this.engineCapacity = engineCapacity;
            this.options = options;
        }

        public ColorsCar getColor() {
            return color;
        }

        public void setColor(ColorsCar color) {
            this.color = color;
        }

        public Enum getModel() {
            return model;
        }

        public Integer getYear() {
            return 2022;
        }

        public Enum getWheelSize() {
            return wheelSize;
        }

        public void setWheelSize(Enum wheelSize) {
            this.wheelSize = wheelSize;
        }

        public Enum getEngineCapacity() {
            return engineCapacity;
        }

        public Set<OptionsCar> getOptions() {
            return options;
        }

        public void setOptions(Set<OptionsCar> options) {
            this.options = options;
        }

        public void deleteAllOptions() {
            this.options.clear();
        }

        public void deteleOption(OptionsCar option) {
            this.options.remove(option);
        }

        public void addOption(OptionsCar option) {
            this.options.add(option);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return color == car.color && Objects.equals(model, car.model) && Objects.equals(wheelSize, car.wheelSize) && Objects.equals(engineCapacity, car.engineCapacity) && Objects.equals(options, car.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, model, wheelSize, engineCapacity, options);
    }
}
