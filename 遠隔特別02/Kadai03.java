class Kadai03 {
    static int calcSum(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        
        return sum;
    }
    public static void main(String[] args) {
        int[] a = new int[args.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }

        int sum = calcSum(a);

        System.out.println("合計：" + sum);

        System.exit(0);
    }    
}
