package interface_learn;

public class Hawk implements Predator {
    
    @Override // menandakan sebuah method harus override
    public void hunt() {
        System.out.println("*The Hawk is hunting*");
    }
}
