public class Entity {
    private String name;
    private int hp;
    private int attack;
    private int level;
    private String element;
    private int basehp;

    public Entity(String name, int hp, int attack, int level, String element) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.level = level;
        this.element = element;
        this.basehp = hp;
    }

    public Entity(String name, int hp, int attack, int level) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.level = level;
        this.element = null;
        this.basehp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getLevel() {
        return this.level;
    }
    
    public String getElement() {
        return this.element;
    }

    public int getBaseHp() {
        return basehp;
    }

    public void getStatus() {
        System.out.println(
              "Name    : " + this.name + 
            "\nlevel   : " + this.level + 
            "\nHp      : " + this.hp + 
            "\nAttack  : " + this.attack + 
            "\nElement : " + this.element
        );
    }

    public void attacked(int attack) {
        if(this.hp - attack >= 0) {
            this.hp = this.hp - attack;
        } else {
            this.hp = 0;
        }
    }

    private void restoreHp() {
        this.hp = this.basehp;
    }

    public void setHp(int hp) {
        this.restoreHp();
        this.hp += hp;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setAttack(int attack) {
        this.attack += attack;
    }

    public void setLevelUp() {
        this.level ++;
    }

    public void setBaseHp(int hp) {
        this.basehp = hp;
    }

    public boolean isKilled() {
        if(this.hp == 0) {
            System.out.println(this.getName() + " has been killed!");
            return true;
        } else {
            return false;
        }
    }
}