public class DormStudentApp {
    public static void main(String[] args) {
        DormStudent Charlie = new DormStudent(4, "建築", "Charlie");
        DormStudent Bravo = new DormStudent(4, "電子", "Bravo");
        
        Charlie.setDoshitsu(Bravo);

        Charlie.shokai();
        Bravo.shokai();  
    }
}
