class Item {
    private String name;
    private int price;

    Item() {
        this.name = "未定";
        this.price = 0;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getPrice() {
        return this.price;
    }

    void setPrice(int price) {
        if(price > 0) {
            this.price = price;
        }
    }
}