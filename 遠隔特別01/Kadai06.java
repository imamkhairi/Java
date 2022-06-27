class Kadai06 {
    static int judge(int a, int b) {
        return a == b ? 1 : 0;
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int result = judge(a, b);

        if(result == 1){
            System.out.println(a + " と " + b + " は同じ");
        } else {
            System.out.println(a + " と " + b + " は違う");
        }

        System.exit(0);
    }    
}
