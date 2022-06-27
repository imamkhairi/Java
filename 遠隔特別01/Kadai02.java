class Kadai02 {
    static double calcArea(double side){
        double area = side*side;
        return area;
    } 
    public static void main(String[] args) {
        double side = Double.parseDouble(args[0]);
        double area = calcArea(side);

        System.out.println("面積：" + area);
        System.exit(0);
    }
}
