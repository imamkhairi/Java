class Game {
    
    static void startGame(Player a, Player b){
        int turn = 1;
        a.status();
        b.status();
        while(a.hp > 0 && b.hp > 0) {
            System.out.println("Turn " + turn + "------------");
            if(turn % 2 == 1){
                a.attack(b);
            }
            else {
                b.attack(a);
            }
            turn ++;
            a.status();
            b.status();
            System.out.println("End turn ----------\n\n");
        }
        
        Game.win(a,b);
    }
    
    static void win(Player a, Player b) {
        if(a.hp == 0) {
            System.out.println(b.name + " win!");
            b.lvlUp();
            b.status();
        } else if(b.hp == 0) {
            System.out.println(a.name + " win!");
            a.lvlUp();
            a.status();
        }
    }
}