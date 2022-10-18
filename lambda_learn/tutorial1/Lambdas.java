package lambda_learn.tutorial1;

public class Lambdas {
    public static void main(String[] args) {
        // Cat myCat = new Cat();
        // myCat.print();
        
        // lambda digunakan untuk passing implementasi dari sebuah method 
        // (menjadikan method (interface) bisa digunakan seperti sebuah object atau variable)
        // jadi tidak perlu untuk passing object lagi
        // lambda hanya bisa digunakan untuk @FunctionalInterface (1 method)

        // Printable lambdaPrintable = (s) -> System.out.println("Meong " + s);

        Printable lambdaPrintable = (s) -> "Meow" + s;
        // ketika hanya ada satu baris dan hanya expression, maka akan jadi return value
        // kalau mau pakai {} dan pake return juga bisa 
        printThing(lambdaPrintable);
    }
    
    static void printThing(Printable thing) {
        thing.print("!");
    }

    // daripada membuat class yang mengimplementasikan sebuah interface, membuat implementasi, membuat object dari class
    // kita bisa membuat lambda expression yang memiliki implementation dari @FunctionalInterface method yang diinginkan
}
