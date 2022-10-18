package interface_learn;

// di interfce bisa declare instance dan method seperti biasa
// tapi gak butuh (tidak bisa) body dari method nya 

// kalau interface hanya memiliki satu method maka disebut FunctionalInterface

@FunctionalInterface // Annotation
public interface Prey {

    void flee();

}
