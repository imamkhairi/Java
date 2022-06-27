class XYVectorApp{
    public static void main (String[] args) {
        XYVector a = new XYVector(3.14, 2.17);
        XYVector b = new XYVector(-0.5, 0.5);

        a.print();
        double r = a.calcDistance(a, b);
        System.out.println("Distance : " + r);
        a.print();
    }
}