public class ClassRoomApp {
    public static void main(String[] args) {
        HomeStudent alan = new HomeStudent(4, "情報", "Alan", "自転車");
        DormStudent beth = new DormStudent(4, "情報", "Beth");
        DormStudent claire = new DormStudent(4, "情報", "Claire");
        HomeStudent dwi = new HomeStudent(4, "情報", "Dwi", "自転車");
        HomeStudent eli = new HomeStudent(4, "情報", "Eli", "自転車");
        HomeStudent freya = new HomeStudent(4, "情報", "Freya", "自転車");

        ClassRoom j4 = new ClassRoom();
        j4.add(alan);
        j4.add(beth);
        j4.add(claire);
        j4.add(dwi);
        j4.add(eli);
        j4.add(freya);

        beth.setDoshitsu(claire);

        j4.shokai();
    }
}