class MyPointApp {
    public static void main (String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        MyPoint mp = new MyPoint(x, y);

        mp.print();

        System.exit(0);
    }    
}
