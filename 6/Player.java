class Player {
    String name;
    int hp;
    int att;
    int lvl;

    Player(String name, int hp, int att, int lvl) {
        this.name = name;
        this.hp = hp;
        this.att = att;
        this.lvl = lvl;
    }

    void status(){
        System.out.println(
            this.name + " status :" +
            "\nlvl : " + this.lvl +            
            "\nhp  : " + this.hp +
            "\natt : " + this.att + "\n"
            );
    }

    void attack(Player a){
        a.hp -= this.att;
        System.out.println(a.name + "is attacked by " + this.name);
    }
}