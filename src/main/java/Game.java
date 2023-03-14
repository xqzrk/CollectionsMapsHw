import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    HashMap<String, Player> playerList = new HashMap<>();

    public void register(Player player) {
        playerList.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = new Player(0, null, 0);
        Player player2 = new Player(0, null, 0);

        if (playerList.containsKey(playerName1)) {
            if (playerList.containsKey(playerName2)) {
                player1 = playerList.get(playerName1);
                player2 = playerList.get(playerName2);
            } else {
                throw new NotRegisteredException(
                        "Игрок " + playerName2 + " не зарегистрирован"
                );
            }
        } else {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

