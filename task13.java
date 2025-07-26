public class task13 {

    static class Vehicle {
        String make;
        String model;
        int year;

        public Vehicle(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }

    static class Car extends Vehicle {
        int numberOfDoors;

        public Car(String make, String model, int year, int numberOfDoors) {
            super(make, model, year);
            this.numberOfDoors = numberOfDoors;
        }

        public void displayDetails() {
            String[] labels = {"Make: ", "Model: ", "Year: ", "Number of Doors: "};
            String[] values = {
                    make,
                    model,
                    Integer.toString(year),
                    Integer.toString(numberOfDoors)
            };
            System.out.println("Car Details:");
            for (int i = 0; i < labels.length; i++) {
                System.out.println(labels[i] + values[i]);
            }
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2022, 4);
        myCar.displayDetails();
    }
}
