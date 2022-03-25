package Homework4.Car;

import Homework4.Enums.*;
import Homework4.Enums.EngineCapacitiesCar.EnumsEngineCapacitiesCar;
import Homework4.Enums.ModelsCar.EnumsModelsCar;
import Homework4.Enums.WheelSizesCar.EnumsWheelSizesCar;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Car {

        private ColorsCar color;
        private final EnumsModelsCar model;
        private EnumsWheelSizesCar wheelSize;
        private final EnumsEngineCapacitiesCar engineCapacity;
        private Set<OptionsCar> options;

        public Car(ColorsCar color,
                   EnumsModelsCar model,
                   EnumsWheelSizesCar wheelSize,
                   EnumsEngineCapacitiesCar engineCapacity) {
            this.color = color;
            this.model = model;
            this.wheelSize = wheelSize;
            this.engineCapacity = engineCapacity;
            this.options = new HashSet<>();
        }

        public Car(ColorsCar color,
                   EnumsModelsCar model,
                   EnumsWheelSizesCar wheelSize,
                   EnumsEngineCapacitiesCar engineCapacity,
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

        public EnumsModelsCar getModel() {
            return model;
        }

        public Integer getYear() {
            return 2022;
        }

        public EnumsWheelSizesCar getWheelSize() {
            return wheelSize;
        }

        public void setWheelSize(EnumsWheelSizesCar wheelSize) {
            this.wheelSize = wheelSize;
        }

        public EnumsEngineCapacitiesCar getEngineCapacity() {
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
        return Objects.equals(model, car.model) && Objects.equals(engineCapacity, car.engineCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, engineCapacity);
    }
}
