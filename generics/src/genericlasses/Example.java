package genericlasses;

public class Example {
    public static <T> void printTruck(Truck<T> truck)
    {
        for(T obj : truck)
        {
            if(obj instanceof Animal)
            {
                System.out.println("Animal: " + ((Animal) obj).getName());
            }else if(obj instanceof Car)
            {
                System.out.println("Car: " + ((Car) obj).getBrand());
            }else if(obj instanceof Machine)
            {
                System.out.println("Machine: " + ((Machine) obj).getTipo());
            }
        }
    }

    public static void main(String[] args) {

        Truck<Animal> animalTruck = new Truck<>(5);
        animalTruck.add(new Animal("Dog", "Mammal"));
        animalTruck.add(new Animal("Cat", "Mammal"));
        animalTruck.add(new Animal("Bird", "Bird"));
        animalTruck.add(new Animal("Fish", "Fish"));
        animalTruck.add(new Animal("Snake", "Reptile"));

        printTruck(animalTruck);

        Truck<Machine> equipmentTruck = new Truck<>(3);
        equipmentTruck.add(new Machine("Excavator"));
        equipmentTruck.add(new Machine("Bulldozer"));
        equipmentTruck.add(new Machine("Crane"));

        printTruck(equipmentTruck);

        Truck<Car> carTruck = new Truck<>(3);
        carTruck.add(new Car("Toyota"));
        carTruck.add(new Car("Ford"));
        carTruck.add(new Car("Chevrolet"));

        printTruck(carTruck);
    }
}
