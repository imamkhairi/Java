class Kadai04 {
    static double calcAverage(int[] score) {
        int total = 0;
        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }
        double average = (double)total/score.length;
        return average;
    }
    public static void main(String[] args) {
        int[] score = new int[args.length]; 

        for (int i = 0; i < args.length; i++) {
            score[i] = Integer.parseInt(args[i]);
        }

        double average = calcAverage(score);
        System.out.println("平均：" + average);
        System.exit(0);
    }    
}
