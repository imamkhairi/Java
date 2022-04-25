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

        //1
        System.out.println(a.dotProduct(b)); 
        
        //2
        // a.sum(b);
        // a.print();
        
        //3
        a.subtrac(b);
        a.print();

        //4
        System.out.println(a.size());
        System.exit(0);
    }

}