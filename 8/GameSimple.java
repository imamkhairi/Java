public class GameSimple {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 15, 5, 1);
        Item sword = new Item("Sword", "fire", 3);
        Monster slime = new Monster("Slime", 20, 3, 1, "water", 6);

        player1.getStatus();
        System.out.println("----------------------\n");

        sword.getStatus();
        System.out.println("----------------------\n");

        player1.setWeapon(sword);
        
        player1.getStatus();
        System.out.println("----------------------\n");
        
        slime.getStatus();
        System.out.println("----------------------\n");
    
        Game.statGame(slime, player1);
    }
    
}
