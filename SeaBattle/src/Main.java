import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] playingField = new int[10][10];
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                if (playingField[i][j] == 0) {
                    System.out.print("\uD83D\uDFE5");
                }
            }
            System.out.println("");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату однопалубного корабля");
        String[] coordinates = scanner.next().split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        System.out.println(x);
        System.out.println(y);
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
 if (i == x && j == y) {
                    System.out.print("\uD83D\uDEE5");
                } else                 if (playingField[i][j] == 0) {
     System.out.print("\uD83D\uDFE5");
 }
            }
            System.out.println("");
        }
    }
}
