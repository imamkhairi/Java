package abstract_learn;

// abstact digunakan agar class ini tidak bisa dibuat object nya
// digunakan untuk class yang masih terlalu ngambang artinya

public abstract class Vehicle {
    
    // ketika abstract method maka ini akan mencegah agar didefinisikan
    abstract void go();

    // juga bisa memuat method biasa
    void test() {
        System.out.println("hehe");
    }
}
