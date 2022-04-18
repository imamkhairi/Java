class KozaApp {
    public static void main(String[] args) {
        Koza my_koza; 
        my_koza = new Koza();

        my_koza.gankin = 350000;
        System.out.println("利息は" + my_koza.risoku(6));

        System.exit(0);
    }
}