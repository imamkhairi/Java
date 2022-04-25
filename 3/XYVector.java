class XYVector {
    double x;
    double y;

    XYVector(){}

    void print() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    double dotProduct(XYVector v) {
        return x*v.x + y*v.y;
    }

    void sum(XYVector v) {
        x = x + v.x;
        y = y + v.y;
        print();
    }

    void subtrac(XYVector v) {
        x = x - v.x;
        y = y - v.y;
        print();
    }

    double size() {
        return Math.sqrt(x*x + y*y);
    }
}