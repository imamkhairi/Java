public class Student {
    private int gakunen;
    private String bunnya;
    private String namae;

    public Student(int gakunen, String bunnya, String namae) {
        this.gakunen = gakunen;
        this.bunnya = bunnya;
        this.namae = namae;
    }

    public int getGakunen() {
        return this.gakunen;
    }

    public String getBunnya() {
        return this.bunnya;
    }

    public String getNamae() {
        return this.namae;
    }

    public void shokai() {
        System.out.println("私は" + this.gakunen + "年" + this.bunnya + "の" + this.namae + "です。");
    }
}