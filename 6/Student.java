class Student
{
    int gakunen;
    String bunnya;
    String namae;
    String jukyo;

    Student(int gakunen, String bunnya, String namae, String jukyo) {
        this.gakunen = gakunen;
        this.bunnya = bunnya;
        this.namae = namae;
        this.jukyo = jukyo;
    }

    void shokai() {
        System.out.println("私は"+ this.gakunen + "年" + this.bunnya + "の" + this.namae + "です。私の住居は" + this.jukyo + "です。\n" );
    }

    static void shokai(Student a) {
        System.out.println("私は"+ a.gakunen + "年" + a.bunnya + "の" + a.namae + "さんです。私の住居は" + a.jukyo + "です。");
    }
//nanti coba kasih ? aja 
    void hantei(Student a) {
        if(this.jukyo.equals(a.jukyo)) {
            System.out.println("私"+ this.namae + "と" + a.namae + "さんは仲間です.");
        } else 
        {
            System.out.println("私"+ this.namae + "と" + a.namae + "さんは仲間ではありません.");
        }
    }

    static void hantei(Student a, Student b){
        if(a.jukyo.equals(b.jukyo)) {
            System.out.println(a.namae + "さんと" + b.namae + "さんは仲間です. \n");
        } else 
        {
            System.out.println(a.namae + "さんと" + b.namae + "さんは仲間ではありません. \n");
        }
    }

    void shinkyu(){
        this.gakunen ++;
        System.out.println("私は" + (this.gakunen) + "年に進級しました!");
    }

    static void shinkyu(Student a){
        a.gakunen ++;
        System.out.println(a.namae + "さんは" + (a.gakunen) + "年に進級しました!");
    }
}