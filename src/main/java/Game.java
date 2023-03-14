import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public Player isRegistered(String name) {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (isRegistered(playerName1) == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (isRegistered(playerName2) == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован"
            );
        }

        Player player1 = new Player(0, null, 0);
        Player player2 = new Player(0, null, 0);

        for (Player player : playerList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
        }
        for (Player player : playerList) {
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
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

