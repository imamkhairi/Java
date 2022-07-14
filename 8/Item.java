public class Item {
    private String name;
    private String element;
    private int att;
    
    Item(String name, String element, int att) {
        this.name = name;
        this.element = element;
        this.att = att;
    } 

    public String getName() {
        return this.name;
    }

    public String getElement() {
        return this.element;
    }

    public int getAtt() {
        return this.att;
    }

    public void getStatus() {
        System.out.println(
            "Name    : " + this.name +
            "\nAttack  : " + this.att +
            "\nElement : " + this.element
            );
    }
}
