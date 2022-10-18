public class DormStudent extends Student {
    private DormStudent doshitsu;

    public DormStudent(int gakunen, String bunnya, String namae) {
        super(gakunen, bunnya, namae);
        this.doshitsu = null;
    }

    public DormStudent getDoshitsu() { 
        return this.doshitsu;
    }

    public void setDoshitsu(DormStudent doshitsu) {
        this.doshitsu = doshitsu;
        doshitsu.doshitsu = this;
    }

    public void shokai() {
        super.shokai();
        if(doshitsu != null) {
            System.out.println("私の同室者は" + this.doshitsu.getNamae() + "です。\n");
        } else {}
    }
}