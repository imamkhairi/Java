class XYVector {
    double x, y;

    XYVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    XYVector() {
        this.x = 0;
        this.y = 0;
    }

    void print() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    double calcNorm() {
        return Math.sqrt(x*x + y*y);
    }

    void add(XYVector b) // bは引数インスタンス 
    {
        this.x += b.x; // 左辺のthisはmainでの「主」であるaに該当し, 
        this.y += b.y; // 右辺の   bはmainでの「従」であるbに該当する. 
    }

    static XYVector add(XYVector a, XYVector b) {
        // この考え方ではthisが存在しない
        XYVector w = new XYVector(); // 新しいインスタンスwを用意し
        w.x = a.x + b.x;             // wに計算結果を入れる
        w.y = a.y + b.y;
        return w;                    // そしてwを返す
    }

    static XYVector substract(XYVector a, XYVector b) {
        XYVector w = new XYVector();
        w.x = a.x - b.x;
        w.y = a.y - b.y;
        return w;
    }

    double calcDistance(XYVector a, XYVector b) {
        XYVector c = XYVector.substract(a, b);
        double r = c.calcNorm();
        return r;
    }
}