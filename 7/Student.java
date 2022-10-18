class Student
{
    private int gakunen;
    private String bunnya;
    private String namae;
    private String jukyo;
    private Item item;

    Student() {
        this.gakunen = 0;
        this.bunnya = "未定";
        this.namae = "未定";
        this.jukyo = "未定";
        this.item = null;
    }

    void shokai() {
        System.out.println("私は"+ 
            this.gakunen + "年" + 
            this.bunnya + 
            "の" + 
            this.namae + 
            "です。私の住居は" + 
            this.jukyo + 
            "です" );
        if(this.item != null) {
            System.out.println("私は" + 
            this.item.getName() + 
            "を持っています.");
        }
    }

    static void shokai(Student a) {
        System.out.println("私は"+ a.gakunen + "年" + a.bunnya + "の" + a.namae + "さんです。私の住居は" + a.jukyo + "です。");
    }

    int getGakunen() {
        return this.gakunen;
    }

    void setGakunen(int gakunen) {
        if(gakunen >= 1 && gakunen <= 5) {
            this.gakunen = gakunen;
        }
    }

    String getBunnya() {
        return this.bunnya;
    }

    void setBunnya(String bunnya) {
        if(bunnya.equals("情報") || 
           bunnya.equals("機械") || 
           bunnya.equals("電気") || 
           bunnya.equals("電子") ||  
           bunnya.equals("建築")) {
            this.bunnya = bunnya;
        }
    }

    String getNamae() {
        return this.namae;
    }

    void setNamae(String namae) {
        this.namae = namae;
    }

    String getJukyo() {
        return this.jukyo;
    }

    void setJukyo(String jukyo) {
        this.jukyo = jukyo;
    }

    Item getItem() {
        return this.item;
    }
    
    void setItem(Item item) {
        this.item = item;
    }
}