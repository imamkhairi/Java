class Kadai01 {
    public static void main(String[] args) {
        int[] a = new int[args.length];

        for(int i = 0; i < a.length ; i++) {
            a[i] = Integer.parseInt(args[i]);
            System.out.println(a[i]);
        }

    System.exit(0);
    }
}
