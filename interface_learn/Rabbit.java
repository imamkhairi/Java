package interface_learn;

// ketika implement interface maka harus define isi method nya di dalam class tsb

public class Rabbit implements Prey{

    @Override
    public void flee() {
        System.out.println("The Rabbit is fleeing");
        
    }
    
}
