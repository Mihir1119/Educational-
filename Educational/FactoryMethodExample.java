interface Vehicle {
    String create();
}

class Car implements Vehicle {
    @Override
    public String create() {
        return "Car created";
    }
}

class Bike implements Vehicle {
    @Override
    public String create() {
        return "Bike created";
    }
}

class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("BIKE")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle vehicle1 = factory.getVehicle("CAR");
        System.out.println(vehicle1.create());

        Vehicle vehicle2 = factory.getVehicle("BIKE");
        System.out.println(vehicle2.create());
    }
}
