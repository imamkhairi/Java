public class Player extends Pet {
    private Item weapon;
    private int exp;

    Player(String name, int hp, int attack, int level) {
        super(name, hp, attack, level);
        this.weapon = null;
        this.exp = 0;
    }

    public Item getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
        this.setElement(weapon.getElement());
        this.setAttack(weapon.getAtt());
        System.out.println(this.getName() + " equipped with " + this.weapon.getName());
    }

    public void attackMonster(Monster monster) {
        System.out.println(monster.getName() + " attacked by " + this.getName() + "\n");
        monster.attacked(this.getAttack());
    }

    public void getStatus() {
        super.getStatus();
        if(weapon != null) {
            System.out.println(
                "Weapon  : " + this.weapon.getName()
            );
        }
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int dropExp) {
        this.exp += dropExp;
    }

    public void lvlUp() {
        if(exp >= 5) {
            System.out.println("Player leveled up!");
            this.setLevelUp();
            this.setHp(this.getLevel()*4);
            this.setBaseHp(this.getHp());
            this.setAttack(this.getLevel()*3);
            this.exp -= 5;
            
            this.getStatus();
        }
    }

}
