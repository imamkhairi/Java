package abstract_learn;

public class Car extends Vehicle{
    // ketika ada abstract method, maka harus mendefinisikannya di sini (child class)
    @Override
    void go(){
        System.out.println("The driver is driving a car");
    }
}
