class XYVectorApp {
    public static void main(String[] args) {
        XYVector a, b;
        a = new XYVector(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        b = new XYVector(Double.parseDouble(args[2]), Double.parseDouble(args[3]));

        System.out.println("A ベクトル");
        a.print();
        System.out.println("B ベクトル");
        b.print();

        System.out.println("Distance :" + a.distance(b));

        //System.out.println("大きさ："+ a.calcNorm());
        
        // a.subtract(b);

        // System.out.println("引いた後：");
        // a.print();

        System.exit(0);
    }

}