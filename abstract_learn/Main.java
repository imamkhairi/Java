package abstract_learn;

public class Main {
    public static void main(String[] args) {

        // abstract =   abstract classes cannot be instantiated, but the can have a subclass
        //              abstract method are declared without an implementation
        
        //Vehicle vehicle = new Vehicle();
        // tidak bisa karena abstract class

        Car car = new Car();
        car.go();

    }
}
