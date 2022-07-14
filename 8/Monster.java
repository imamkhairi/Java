public class Monster extends Entity {
    int dropExp;
    Monster(String name, int hp, int attack, int level, String element, int dropExp) {
        super(name, hp, attack, level, element);
        this.dropExp = dropExp;
    }

    public void attackPlayer(Player player) {
        System.out.println(player.getName() + " attacked by" + this.getName() + "\n");
        player.attacked(this.getAttack());
    }

    public int getDropExp() {
        return dropExp;
    }
    
    public void getStatus() {
        super.getStatus();
        System.out.println(
            "Drop Exp : " + this.dropExp
        );
    }

}
