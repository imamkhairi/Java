class GameSimple{
    public static void main(String[] args) {
        Player player1 = new Player("Player1", 10, 6, 1);
        Player player2 = new Player("Player2", 10, 4, 1);

        Game.startGame(player1, player2);

        System.exit(0);
    }
}