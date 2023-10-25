import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    static Scanner scanner;
    static Player firstPlayer;
    static Player secondPlayer;
    static Player second;
    static Player randomPlayer;

    public static void startGame() {
        System.out.println("Приветствую вас в морском бою !!!");
        System.out.println("Для начала представьтесь");
        System.out.println("Участник один, введите ваше имя:");

        scanner = new Scanner(System.in);
        firstPlayer = new Player(scanner.nextLine());

        System.out.println("Отлично! Добро пожаловать " + firstPlayer.getName());
        System.out.println("Участник два, ваша очередь представляться, введите ваше имя:");

        scanner = new Scanner(System.in);
        secondPlayer = new Player(scanner.nextLine());

        System.out.println("Отлично! Добро пожаловать " + secondPlayer.getName());
//ознакомления с правилами игры
        System.out.println("Давайте приступать к бою! " + secondPlayer.getName() + " отвернитесь от компьютера, " + firstPlayer.getName() + " нужно расставить корабли");

        firstPlayer.playingFieldCreate();

        System.out.println("Отлично! " + firstPlayer.getName() + " расставил корабли и готов к бою");
        System.out.println(firstPlayer.getName() + " отвернитесь от компьютера, " + secondPlayer.getName() + " нужно расставить корабли");

        secondPlayer.playingFieldCreate();

        System.out.println("Отлично! " + secondPlayer.getName() + " расставил корабли и готов к бою");
        System.out.println("И теперь мы готовы начинать. Но сначала надо запомнить правило: \"это не игры, здесь всё серьёзно\" ");

        var random = new SecureRandom();
        var list = Arrays.asList(firstPlayer, secondPlayer);
        randomPlayer = list.get(random.nextInt(list.size()));

        System.out.println("Игрок " + randomPlayer.getName() + " ходите первый");

        if (randomPlayer == firstPlayer) {
            second = secondPlayer;
        } else second = firstPlayer;
        scanner = new Scanner(System.in);
        String str = scanner.next();
        add(str);

    }


    private static void add(String str) {
        String[] coordinates = str.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        randomPlayer.shoot(x, y, second.getPlayingField());

    }

    private static boolean chek() {
        boolean chek = false;


    }

}