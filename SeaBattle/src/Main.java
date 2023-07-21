import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] playingField = new String[10][10];
        int count = 0;
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                playingField[i][j] = "\u2B1C";
                System.out.print(playingField[i][j] + "  ");
            }
            System.out.println("");
        }
        while (count < 4) {
            rec(playingField);
            count++;
        }
    }

    public static int rec(String[][] playingField) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату однопалубного корабля");
        String[] coordinates = scanner.next().split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                if (i == x && j == y) {
                    if (playingField[x][y].contains("\u2B1C")) {
                        playingField[x][y] = "\uD83D\uDEE5";
                    } else if (!playingField[x][y].contains("\u2B1C")) {
                        System.out.println("Error");
                        return rec(playingField);
                    }
                }
            }

        }
        for (String[] strings : playingField) {
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println("");
        }
        return 0;
    }
}