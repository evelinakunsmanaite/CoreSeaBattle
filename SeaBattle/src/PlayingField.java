import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayingField {
    Scanner scanner;
    private int count = 0;
    static String[][] playingField = new String[10][10];

    public static void playingFieldCreator() {
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                playingField[i][j] = Ships.getDefaultValue();
                System.out.print(playingField[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Поздравляю, ваше поле создано! Теперь давай его заполним)");
    }

    private void getPlayingField(String[][] playingField) {
        for (String[] strings : playingField) {
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println();
        }
    }

    private void addSingleDeckShip() {
        while (count < 4) {
            scanner = new Scanner(System.in);
            switch (count) {
                case 0 -> System.out.println("Введите координаты первого однопалубного корабля: ");
                case 1 -> System.out.println("Введите координаты второго однопалубного корабля: ");
                case 2 -> System.out.println("Введите координаты третьего однопалубного корабля: ");
                case 3 -> System.out.println("Введите координаты четвёртого однопалубного корабля: ");
                default -> System.out.println("Количество однопалубных кораблей должно быть 4");
            }
            String str = scanner.next();
            // метод проверки строки через регекс
            if (Ships.regexMatching(str,1)) {
                String[] coordinates = str.split(",");
                //проверка добавления
                count++;
            } else {
                addSingleDeckShip();
            }
        }
        count = 0;
    }



//    private int addSingleDeckShip(String[][] playingField) {
//        scanner = new Scanner(System.in);
//        System.out.println("Введите координаты однопалубного корабля");
//        String str = scanner.next();
//        String[] coordinates = str.split(",");
//
////        for (int i = 0; i < playingField.length; i++) {
////            for (int j = 0; j < playingField[i].length; j++) {
////                if (i == singleDeckShip.getX() && j == singleDeckShip.getY()) {
////                    if (playingField[singleDeckShip.getX()][singleDeckShip.getY()].contains("\uD83D\uDFE8")) {
////                        playingField[singleDeckShip.getX()][singleDeckShip.getY()] = "\uD83D\uDEF3️";
////                    } else if (!playingField[singleDeckShip.getX()][singleDeckShip.getY()].contains("\uD83D\uDFE8")) {
////                        System.out.println("Error");
////                        return addSingleDeckShip(playingField);
////                    }
////                } else if ((i >= singleDeckShip.getX() - 1 && i <= singleDeckShip.getX() + 1) &&
////                        (j >= singleDeckShip.getY() - 1 && j <= singleDeckShip.getY() + 1)) {
////
////                    playingField[i][j] = "\uD83D\uDFE5";
////                }
////            }
////        }
//
//        for (String[] strings : playingField) {
//            for (String string : strings) {
//                System.out.print(string + "  ");
//            }
//            System.out.println();
//        }
//        return 0;
//    }
//
//    private int addDoubleDeckShip(String[][] playingField) {
//        scanner = new Scanner(System.in);
//        System.out.println("Введите координаты двухпалубного корабля");
//        String[] twoCoordinates = scanner.next().split(";");
//        System.out.println(Arrays.toString(twoCoordinates));
//        List<Integer> coordinate = new ArrayList<>();
//        for (String coordinates : twoCoordinates) {
//            String[] array = coordinates.split(",");
//            coordinate.add(Integer.parseInt(array[0]));
//            coordinate.add(Integer.parseInt(array[1]));
//        }
//        if (creatorArrays(coordinate)) {
//            DoubleDeckShip doubleDeckShip = new DoubleDeckShip(coordinate.get(0), coordinate.get(1), coordinate.get(2), coordinate.get(3));
//            arrayY = null;
//            arrayX = null;
//        } else addDoubleDeckShip(playingField);
//
////
////        if ((doubleDeckShip.getX1() == doubleDeckShip.getX2() || doubleDeckShip.getY1() == doubleDeckShip.getY2()) &&
////                !((doubleDeckShip.getX1() == doubleDeckShip.getX2() && doubleDeckShip.getY1() == doubleDeckShip.getY2()))) {
////
////            for (int i = 0; i < playingField.length; i++) {
////                for (int j = 0; j < playingField[i].length; j++) {
////                    if (i == doubleDeckShip.getX1() && j == doubleDeckShip.getY1()) {
////                        if (playingField[i][j].contains("\uD83D\uDFE8")) {
////                            playingField[i][j] = "\uD83D\uDEF3️";
////                        } else if (!playingField[doubleDeckShip.getX1()][doubleDeckShip.getY1()].contains("\uD83D\uDFE8")) {
////                            System.out.println("Error");
////                            return addDoubleDeckShip(playingField);
////                        }
////                    } else if (i == doubleDeckShip.getX2() && j == doubleDeckShip.getY2()) {
////                        if (playingField[i][j].contains("\uD83D\uDFE8")) {
////                            playingField[i][j] = "\uD83D\uDEF3️";
////                        } else if (!playingField[doubleDeckShip.getX2()][doubleDeckShip.getY2()].contains("\uD83D\uDFE8")) {
////                            System.out.println("Error");
////                            return addDoubleDeckShip(playingField);
////                        }
////                    } else if (doubleDeckShip.getX1() < doubleDeckShip.getX2() || doubleDeckShip.getY1() < doubleDeckShip.getY2()) {
////                        if ((i >= doubleDeckShip.getX1() - 1 && i <= doubleDeckShip.getX2() + 1) &&
////                                (j >= doubleDeckShip.getY1() - 1 && j <= doubleDeckShip.getY2() + 1)) {
////                            playingField[i][j] = "\uD83D\uDFE5";
////                        }
////                    } else if (doubleDeckShip.getX1() > doubleDeckShip.getX2() || doubleDeckShip.getY1() > doubleDeckShip.getY2()) {
////                        if ((i >= doubleDeckShip.getX2() - 1 && i <= doubleDeckShip.getX1() + 1) &&
////                                (j >= doubleDeckShip.getY2() - 1 && j <= doubleDeckShip.getY1() + 1)) {
////                            playingField[i][j] = "\uD83D\uDFE5";
////                        }
////                    }
////                }
////            }
////        } else {
////            System.out.println("Error");
////            addDoubleDeckShip(playingField);
////        }
////        for (String[] strings : playingField) {
////            for (String string : strings) {
////                System.out.print(string + "  ");
////            }
////            System.out.println("");
////        }
//        return 0;
//    }
//
//    private int addTripleDeckShip(String[][] playingField) {
//        scanner = new Scanner(System.in);
//        System.out.println("Введите координаты двухпалубного корабля");
//        String[] twoCoordinates = scanner.next().split(";");
//        System.out.println(Arrays.toString(twoCoordinates));
//        List<Integer> coordinate = new ArrayList<>();
//        for (String coordinates : twoCoordinates) {
//            String[] array = coordinates.split(",");
//            coordinate.add(Integer.parseInt(array[0]));
//            coordinate.add(Integer.parseInt(array[1]));
//        }
//        if (creatorArrays(coordinate)) {
//            TripleDeckShip tripleDeckShip = new TripleDeckShip(coordinate.get(0), coordinate.get(1), coordinate.get(2), coordinate.get(3), coordinate.get(4), coordinate.get(5));
//            arrayY = null;
//            arrayX = null;
//        } else addTripleDeckShip(playingField);
//        return 0;
//
//    }
//
//    private int addQuadDeckShip(String[][] playingField) {
//        scanner = new Scanner(System.in);
//        System.out.println("Введите координаты двухпалубного корабля");
//        String[] twoCoordinates = scanner.next().split(";");
//        System.out.println(Arrays.toString(twoCoordinates));
//        List<Integer> coordinate = new ArrayList<>();
//        for (String coordinates : twoCoordinates) {
//            String[] array = coordinates.split(",");
//            coordinate.add(Integer.parseInt(array[0]));
//            coordinate.add(Integer.parseInt(array[1]));
//        }
//        if (creatorArrays(coordinate)) {
//            QuadDeckShip QuadDeckShip = new QuadDeckShip(coordinate.get(0), coordinate.get(1), coordinate.get(2), coordinate.get(3), coordinate.get(4), coordinate.get(5), coordinate.get(6), coordinate.get(7));
//            arrayY = null;
//            arrayX = null;
//        } else addQuadDeckShip(playingField);
//        return 0;
//    }
//
//    private boolean creatorArrays(List<Integer> coordinate) {
//        for (int i = 0; i < coordinate.size(); i++) {
//            if (i % 2 == 0) {
//                arrayX.add(coordinate.get(i));
//            } else arrayY.add(coordinate.get(i));
//        }
//
//        return checker(arrayX) && checker(arrayY);
//    }
//
//    private boolean checker(List<Integer> coordinate) {
//        boolean check = false;
//
//        for (int i = 1; i < coordinate.size(); i++) {
//            if (coordinate.get(i) == coordinate.get(i - 1)) {
//                check = true;
//            } else if ((coordinate.get(i - 1) == (coordinate.get(i) - 1)) ||
//                    (i < coordinate.size() - 1 && (coordinate.get(i - 1) == (coordinate.get(i) + 1)))) {
//                check = true;
//            } else check = false;
//        }
//
////            for (int i = 2; i < coordinate.size(); i++) {
////                if (i % 2 == 0) {
////                    if (coordinate.get(i) == coordinate.get((i - 2 + coordinate.size())%coordinate.size())) {
////                        if (i == 2) {
////                            arrayX.add(coordinates[0]);
////                        }
////                        arrayX.add(coordinates[i]);
////                        for (int j = 1; j < coordinates.length; j++) {
////                            if (j % 2 != 0) {
////                                if ((coordinates[j] == (coordinates[j - 1] + 1)) ||
////                                        (coordinates[j] == (coordinates[j - 1] - 1))) {
////                                    arrayY.add(coordinates[j]);
////                                } else check = false;
////                            }
////                        }
////                    } else check = false;
////                } else {
////                    if (coordinates[i] == coordinates[i - 2]) {
////                        if (i == 3) {
////                            arrayY.add(coordinates[1]);
////                        }
////                        arrayY.add(coordinates[i]);
////                        //x
////                    } else {
////                        check = false;
////                    }
////                }
////            }
//
//
//        return check;
//    }


}
