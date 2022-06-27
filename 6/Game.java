class Game {
    int turn;
    Game() {
        turn = 1;
    }
    public void start(Player a, Player b){
        a.status();
        b.status();
        if(a.hp != 0 || b.hp != 0) {
            if(turn % 2 == 1){
                a.attack(b);
            }
            else {
                b.attack(a);
            }
            a.status();
            b.status();
        }
    }
}