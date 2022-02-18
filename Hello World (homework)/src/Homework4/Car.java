package Homework4;

import java.util.HashSet;
import java.util.Set;

public class Car {

        private String color;
        private final String model;
        private final Integer releaseYear;
        private String wheelSize;
        private String engineCapacity;
        private Set<Options> options;

        public Car(Colors color, Models model, Integer releaseYear, WheelSize wheelSize, EngineCapacity engineCapacity) {
            this.color = color.getName();
            this.model = model.getName();
            this.releaseYear = releaseYear;
            this.wheelSize = wheelSize.getName();
            this.engineCapacity = engineCapacity.getName();
            this.options = new HashSet<>();
        }

        public Car(Colors color, Models model, Integer releaseYear, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
            this.color = color.getName();
            this.model = model.getName();
            this.releaseYear = releaseYear;
            this.wheelSize = wheelSize.getName();
            this.engineCapacity = engineCapacity.getName();
            this.options.add(options);
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public Integer getReleaseYear() {
            return releaseYear;
        }

        public String getWheelSize() {
            return wheelSize;
        }

        public void setWheelSize(String wheelSize) {
            this.wheelSize = wheelSize;
        }

        public String getEngineCapacity() {
            return engineCapacity;
        }

        public void setEngineCapacity(String engineCapacity) {
            this.engineCapacity = engineCapacity;
        }

        public Set<Options> getOptions() {
            return options;
        }

        public void setOptions(Options options) {
            this.options.add(options);
        }

        public void deteleOption(Options option) {
            this.options.remove(option);
        }

        public void addOption(Options option) {
            this.options.add(option);
        }

        @Override
        public String toString() {
            return "Автомобиль MAZDA" +
                    "\nцвет: " + color +
                    "\nмодель: " + model +
                    "\nгод выпуска: " + releaseYear +
                    "\nразмер колёс: " + wheelSize +
                    "\nобъём двигателя: " + engineCapacity +
                    "\nопции: " + options;
        }
}
