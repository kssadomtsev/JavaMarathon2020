package FinalProject.model;

import FinalProject.utils.Validator;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] players;

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void init() {
        players = new Player[2];
        players[0] = new Player("Player1");
        players[1] = new Player("Player2");
        initBattleField(players[0]);
        initBattleField(players[1]);
    }

    public void start() {
        // Select who will start game
        Random rand = new Random();
        int firstAttempt = rand.nextInt() % 2;
        System.out.println("Игру начинает игрок " + players[firstAttempt].getName());
        int currentPlayer = firstAttempt;
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        // Run game until someone get win
        while (!win) {
            System.out.println(players[currentPlayer].getName() + ", введите координаты для атаки (формат: x,y)");
            boolean correctAttempt = false;
            String input = "";
            while (!correctAttempt) {
                input = scanner.nextLine();
                correctAttempt = Validator.validateCoordinate(input);
            }
            Coordinate coordinateAttack = Validator.getCoordinateFromString(input);
            String attackStatus = players[getNextPlayer(currentPlayer)].attacked(coordinateAttack);
            System.out.println("Результат атаки: " + attackStatus);
            switch (attackStatus) {
                case "Мимо!":
                    System.out.println("Ход переходит к игроку: " + players[getNextPlayer(currentPlayer)].getName());
                    currentPlayer = getNextPlayer(currentPlayer);
                    break;
                case "Попадание!":
                    System.out.println("Игрок " + players[currentPlayer].getName() + " продолжает ход");
                    break;
                case "Утопил!":
                    System.out.println("Количество живых кораблей противника: " + players[getNextPlayer(currentPlayer)].getAliveShipCount());
                    if (players[getNextPlayer(currentPlayer)].getAliveShipCount() == 0) {
                        System.out.println("Игрок " + players[currentPlayer].getName() + " выиграл! Игра окончена");
                        win = true;
                    } else {
                        System.out.println("Игрок " + players[currentPlayer].getName() + " продолжает ход");
                    }
                    break;
            }
        }
    }

    private int getNextPlayer(int currentPlayer) {
        return currentPlayer == 0 ? 1 : 0;
    }

    public void initBattleField(Player player) {
        System.out.println("Начнем расставлять корабли на поле " + player.getName() + ". Другой игрок, не смотри!");
        player.placeShips();
    }
}
