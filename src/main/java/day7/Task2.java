package day7;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Player.info();
        Player p1 = new Player();
        players.add(p1);
        Player.info();
        Player p2 = new Player();
        players.add(p2);
        Player.info();
        Player p3 = new Player();
        players.add(p3);
        Player.info();
        Player p4 = new Player();
        players.add(p4);
        Player.info();
        Player p5 = new Player();
        players.add(p5);
        Player.info();
        Player p6 = new Player();
        players.add(p6);
        Player.info();
        players.stream().map(Player::getStamina).forEach(System.out::println);
        for (int i = 0; i < 100; i++) {
            players.forEach(Player::run);
        }
        players.stream().map(Player::getStamina).forEach(System.out::println);
        Player.info();
    }
}
