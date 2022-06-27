class GameSimple{
    public static void main(String[] args) {
        Player player1 = new Player("player1", 10, 4, 1);
        Player player2 = new Player("player2", 10, 2, 1);

        Game.start(player1, player2);

    }
}