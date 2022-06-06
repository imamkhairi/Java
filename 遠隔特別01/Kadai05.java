class Kadai05 {
    static int judge(int a) {
        int result = a%2 == 0 ? 0 : 1;
        return result;
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int result = judge(a);
        if(result == 0){
            System.out.println(a + "は偶数");
        } else {
            System.out.println(a + "は奇数");
        }
        
        System.exit(0);
    }    
}
