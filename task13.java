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
        Car myCar = new Car("LIGHT UTILITY VEHICLE", "High Mobility Multipurpose Wheeled Vehicle (HMMWV)", 2010, 4);
        myCar.displayDetails();

        Car myCar1 = new Car("Main BATTLE TANK", "M1A2 SEPv3", 2005, 2);
        myCar1.displayDetails();

        Car myCar2 = new Car("FORD", "RANGER RAPTOR", 2025, 4);
        myCar2.displayDetails();

        Car myCar3 = new Car("TOYOTA", "VELOZ", 2025, 4);
        myCar3.displayDetails();
        
    }
}
