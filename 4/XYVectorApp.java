class XYVectorApp {
    public static void main(String[] args) {
        XYVector a, b;
        a = new XYVector(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        b = new XYVector(Double.parseDouble(args[2]), Double.parseDouble(args[3]));

        System.out.println("A ベクトル");
        a.print();
        System.out.println("B ベクトル");
        b.print();

        a.subtract(b);
        
        System.out.println("Distance" + a.calcNorm());
        
        System.exit(0);
    }

}