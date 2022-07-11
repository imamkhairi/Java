public class DormStudentApp {
    public static void main(String[] args) {
        DormStudent Charlie = new DormStudent(4, "建築", "Charlie");
        DormStudent Bravo = new DormStudent(4, "電子", "Bravo");
        DormStudent Alpha = new DormStudent(4, "情報", "Alpha");

        Charlie.setDoshitsu(Bravo);

        Charlie.shokai();
        Alpha.shokai();    
    }
}