import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        List<Point> p = new ArrayList<Point>();
        p.add(new Point(1,1));
        p.add(new Point(2,2));
        p.add(new Point(3,3));

        //Untuk menghapus dari list pake ini aja
        for(int i = 0; i < p.size(); i ++) {
            if(p.get(i).x == 1 && p.get(i).y == 1) {
                // System.out.println("get");
                p.remove(i);
            }
            // System.out.println(p.get(i));
        }

        for(Point t : p) {
            // System.out.println(t);
                if(t.x == 1 && t.y == 1) {
                    // p.remove(2);
                }
        }
        System.out.println(p);
    }
}