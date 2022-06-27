class Kadai05 {
    static void printArray(int[] a) {
        for (int i = 0; i < (a.length - 1); i++) {
            System.out.println(a[i] + " " + a[i+1]);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[args.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }

        printArray(a);
        
        System.exit(0);
    }    
}
