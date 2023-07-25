import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        System.out.println("Приветствую вас в морском бою !!!");
        System.out.println("Для начала представьтесь");
        System.out.println("Участник один, введите ваше имя:");
        scanner = new Scanner(System.in);
        Player firstPlayer = new Player(scanner.nextLine());
        System.out.println("Отлично! Добро пожаловать " + firstPlayer.getName());
        System.out.println("Участник два, ваша очередь представляться, введите ваше имя:");
        scanner = new Scanner(System.in);
        Player secondPlayer = new Player(scanner.nextLine());
        System.out.println("Отлично! Добро пожаловать " + secondPlayer.getName());
//ознакомления с правилами игры
        System.out.println("Давайте приступать к бою! " + secondPlayer.getName() + " отвернитесь от компьютера, " + firstPlayer.getName() + " нужно расставить корабли");
        Player.playingFieldCreate();
        System.out.println("Отлично! " + firstPlayer.getName() + " расставил корабли и готов к бою");
        System.out.println(firstPlayer.getName() + " отвернитесь от компьютера, " + secondPlayer.getName() + " нужно расставить корабли");
        Player.playingFieldCreate();
        System.out.println("Отлично! " + secondPlayer.getName() + " расставил корабли и готов к бою");
        System.out.println("И теперь мы готовы начинать. Но сначала надо запомнить правило: \"это не игры, здесь всё серьёзно\" ");

    }


}