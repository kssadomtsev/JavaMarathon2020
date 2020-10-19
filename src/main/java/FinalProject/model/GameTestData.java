package FinalProject.model;


public class GameTestData {
    private static Player[] players;

    public static Game getTestGame() {
        Game game = new Game();
        players = new Player[]{new Player("TestPlayer1"), new Player("TestPlayer2")};
        game.setPlayers(players);
        return game;
    }
}
