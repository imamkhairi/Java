class KozaApp3 {
    public static void main(String[] args) {
        Koza my_koza; 
        my_koza = new Koza();
        
        my_koza.gankin = Integer.parseInt(args[0]);
        int i;
        for(i = 1; i <= Integer.parseInt(args[1]); i++){
            System.out.println("利息は" + my_koza.risoku(i));
        }

        System.exit(0);
    }
}