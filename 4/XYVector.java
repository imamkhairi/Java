class XYVector {
    double x;
    double y;

    XYVector(double x, double y){
        this.x = x;
        this.y = y;
    }

    void print() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    // double dotProduct(XYVector v) {
    //     return x*v.x + y*v.y;
    // }

    // void sum(XYVector v) {
    //     x = x + v.x;
    //     y = y + v.y;
    //     print();
    // }

    void subtract(XYVector v) {
        x -= v.x;
        y -= v.y;
    }

    double calcNorm() {
        return Math.sqrt(x*x + y*y);
    }

    double distance(XYVector v) {
        subtract(v);
        return calcNorm();
    }
}