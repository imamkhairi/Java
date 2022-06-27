class Kadai07 {
    static int judge(int a) {
        return a >= 0 && a <= 10 ? 1 : 0;
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int result = judge(a);
        if(result == 1) {
            System.out.println(a + " is in range of 0 - 10");
        } else {
            System.out.println(a + " is outside of 0 - 10");
        }
        System.exit(0);
    }    

}
