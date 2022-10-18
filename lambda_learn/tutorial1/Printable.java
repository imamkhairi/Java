package lambda_learn.tutorial1;

@FunctionalInterface // compiler akan memaksa hanya ada 1 abstract method
public interface Printable {
    
    String print(String sufffix);

}
