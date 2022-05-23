class Kadai03 {
    static double calcArea(double height, double base) {
        double area = (base * height)/2;
        return area;
    }
    public static void main(String[] args) {
        double height = Double.parseDouble(args[0]);
        double base = Double.parseDouble(args[1]);

        double area = calcArea(height, base);
        System.out.println("三角形の面積：" + area);
        System.exit(0);
    }    
}
