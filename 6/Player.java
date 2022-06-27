class Player {
    String name;
    int hp;
    int att;
    int lvl;
    int basehp;

    Player(String name, int hp, int att, int lvl) {
        this.name = name;
        this.hp = hp;
        this.basehp = hp;
        this.att = att;
        this.lvl = lvl;
    }

    void status() {
        System.out.println(
            this.name + " status :" +
            "\nlvl : " + this.lvl +            
            "\nhp  : " + this.hp +
            "\natt : " + this.att + "\n"
            );
    }

    void attack(Player a) {
        if(a.hp - this.att > 0) {
            a.hp -= this.att;
        } else {
            a.hp = 0;
        }
        System.out.println(a.name + " is attacked by " + this.name + ". Damage : " + this.att + "\n");
    }

    void restoreHp() {
        this.hp = this.basehp;
    }

    void lvlUp() {
        System.out.println(this.name + " leveled up!");
        restoreHp();
        this.lvl ++;
        this.hp += 5*lvl;
        this.basehp = this.hp;
        this.att += 3*lvl;
    }
}