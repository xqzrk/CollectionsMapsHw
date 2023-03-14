import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    Player player1 = new Player(1, "Razor", 15);
    Player player2 = new Player(2, "Reaper", 10);
    Player player3 = new Player(3, "Viper", 11);
    Player player4 = new Player(4, "Crush", 21);
    Player player5 = new Player(5, "Bomber", 7);
    Player player6 = new Player(6, "Killer", 5);
    Player player7 = new Player(7, "Smasher", 32);
    Player player8 = new Player(8, "Demolition", 10);

    @Test
    public void shouldRegisterPlayer() {
        Game repo = new Game();
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        HashMap<String, Player> actual = repo.playerList;
        HashMap<String, Player> expected = new HashMap<>((Map.of("Razor", player1, "Reaper", player2, "Viper", player3)));

        assertTrue(actual.equals(expected));
    }

    @Test
    public void shouldMakeRoundIfPlayer1Wins() {
        Game repo = new Game();
        repo.register(player1);
        repo.register(player2);
        int actual = repo.round("Razor", "Reaper");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeRoundIfPlayer2Wins() {
        Game repo = new Game();
        repo.register(player3);
        repo.register(player4);
        int actual = repo.round("Viper", "Crush");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldErrorMsgIfPlayer1NotRegistered() {
        Game repo = new Game();
        repo.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Razor", "Reaper");
        });
    }

    @Test
    public void shouldErrorMsgIfPlayer2NotRegistered() {
        Game repo = new Game();
        repo.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Razor", "Reaper");
        });
    }

    @Test
    public void shouldMakeRoundEqualStrength() {
        Game repo = new Game();
        repo.register(player2);
        repo.register(player8);
        int actual = repo.round("Reaper", "Demolition");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}

