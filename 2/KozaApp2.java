class KozaApp2 {
    public static void main(String[] args) {
        Koza my_koza; 
        my_koza = new Koza();

        my_koza.gankin = Integer.parseInt(args[0]);
        System.out.println("利息は" + my_koza.risoku(3));

        System.exit(0);
    }
}