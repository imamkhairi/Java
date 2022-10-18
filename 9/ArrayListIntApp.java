public class ArrayListIntApp {
    public static void main (String[] args) {
        ArrayListInt a = new ArrayListInt();
        a.add(314); 
        a.add(217); 
        a.add(173);
        a.add(1);
        a.add(2);
        a.add(3);
        a.print();   

        // int[] a = new int[2];
        // a[1] = 2;
        // a[0] = 1;
        // a[2] = 3;
        
        // for(int i = 0; i < a.length; i++)
        // {
        //     System.out.println(a[i]);
        // }
    }
}