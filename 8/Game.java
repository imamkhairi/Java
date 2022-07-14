public class Game {
    static void statGame(Monster monster, Player player) {
        int turn = 1;
        System.out.println("Game Start! ");

        while(monster.getHp() > 0 && player.getHp() > 0) {
            System.out.println("Turn " + turn + "------------");
            if(turn % 2 == 1) {
                player.attackMonster(monster);
            } else {
                monster.attackPlayer(player);
            }
            turn ++;

            player.getStatus();
            System.out.println();
            
            monster.getStatus();
            System.out.println();
            
            System.out.println("End turn ----------\n\n");
        }

        Game.win(monster, player);
        player.lvlUp();
    }

    static void win (Monster monster, Player player) {
        if(monster.isKilled(player)) {
            System.out.println(player.getName() + " win!");
        } else if (player.isKilled()) {
            System.out.println(monster.getName() + " win!");
        }
    }



    // static void win(Monster monster, Player player) {
    //     if(monsterKilled(monster, player)) {
    //         System.out.println(player.getName() + " win!");
    //         player.lvlUp();
    //     } else if(playerKilled(player)) {
    //         System.out.println(monster.getName() + " win!");
    //     }
    // }

    // static boolean monsterKilled(Monster monster, Player player) {
    //     if(monster.getHp() == 0) {
    //         player.setExp(monster.getDropExp());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // static boolean playerKilled(Player player) {
    //     if(player.getHp() == 0) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
}
