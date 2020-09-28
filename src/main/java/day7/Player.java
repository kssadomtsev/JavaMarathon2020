package day7;

public class Player {
    private final static int MAX_STAMINA = 100;
    private final static int MIN_STAMINA = 0;
    private static int countPlayers = 0;
    private int stamina;

    public Player() {
        if (countPlayers < 6) {
            stamina = 90 + (int) (Math.random() * ((MAX_STAMINA - 90) + 1));
            countPlayers++;
        }
    }

    public Player(int stamina) {
        if (countPlayers < 6) {
            this.stamina = stamina;
            countPlayers++;
        }
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public int getStamina() {
        return stamina;
    }

    public void run() {
        if (stamina > MIN_STAMINA) {
            stamina--;
            if (stamina == MIN_STAMINA) {
                countPlayers--;
            }
        }
    }

    public static void info() {
        if (countPlayers < 6) {
            String ending;
            if (countPlayers == 1) {
                ending = " свободное место";
            } else if (countPlayers == 0 || countPlayers == 5) {
                ending = " свободных мест";
            } else {
                ending = " свободных места";
            }
            System.out.println("Команды неполные. На поле еще есть " + countPlayers + ending);
        } else {
            System.out.println("На поле нет свободных мест");
        }
    }


}
