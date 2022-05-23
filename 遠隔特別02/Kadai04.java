class Kadai04 {
    static int fidMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            } else {
                continue;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = new int[args.length];

        for (int i = 0; i < a.length; i ++) {
            a[i] = Integer.parseInt(args[i]);
        }

        int max = fidMax(a);

        System.out.println("最高点：" + max);

        System.exit(0);
    }    
}
