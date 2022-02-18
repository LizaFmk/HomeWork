package Homework4;

//////////////////////////////// Сервис ////////////////////////////////

// меняет цвет, размер колёс, устанавливает-добавляет-удаляет опции и отправляет обратно в автосалон

public class MazdaService {

        public Car changeWheelSize(Car car, WheelSize wheelSize) {
            car.setWheelSize(wheelSize.getName());
            return car;
        }

        public Car changeColor(Car car, Colors color) {
            car.setColor(color.getName());
            return car;
        }

        public Car setOptions(Car car, Options options) {
            car.setOptions(options);
            return car;
        }

        public Car deleteOption(Car car, Options option) {
            car.deteleOption(option);
            return car;
        }

        public Car addOption(Car car, Options option) {
            car.addOption(option);
            return car;
        }
}
