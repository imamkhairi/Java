class XYVectorApp {
    public static void main(String[] args) {
        XYVector a, b;
        a = new XYVector();
        b = new XYVector();

        a.x = Double.parseDouble(args[0]);
        a.y = Double.parseDouble(args[1]);
        a.print();

        System.out.println("----------");

        b.x = Double.parseDouble(args[2]);
        b.y = Double.parseDouble(args[3]);
        b.print();

        System.out.println("----------");

        System.out.println(a.dotProduct(b));//内積

        a.sum(b);//足算

        a.subtrac(b);//減算

        System.out.println(a.size());//ノマル

        System.exit(0);
    }

}