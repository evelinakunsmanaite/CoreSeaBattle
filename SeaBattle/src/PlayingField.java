import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class PlayingField {
    static Scanner scanner;
    private static int count = 0;
    private static String[][] playingField = new String[10][10];
    private static SingleDeckShip singleDeckShip;
    private static DoubleDeckShip doubleDeckShip;
    private static TripleDeckShip tripleDeckShip;
    private static QuadDeckShip quadDeckShip;
    private static List<Integer> arrayY;
    private static List<Integer> arrayX;


    public static void playingFieldCreator() {
        System.out.println("    0   1   2   3   4    5   6   7   8   9");
        for (int i = 0; i < playingField.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < playingField[i].length; j++) {
                playingField[i][j] = Ships.getDefaultValue();
                System.out.print(playingField[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Поздравляю, ваше поле создано! Теперь давай его заполним)");
        addSingleDeckShip();
        addDoubleDeckShip();
        addTripleDeckShip();
        addQuadDeckShip();
    }

    private static void getPlayingField(String[][] playingField) {
        System.out.println("    0   1   2   3   4   5    6   7   8   9");
        for (int i = 0; i < playingField.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < playingField[i].length; j++) {
                System.out.print(playingField[i][j] + "  ");
            }
            System.out.println();
        }
    }


    private static void addSingleDeckShip() {
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

            if (Ships.regexMatching(str, 1)) {
                String[] coordinates = str.split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (playingField[x][y].contains(Ships.getDefaultValue())) {
                    singleDeckShip = new SingleDeckShip(x, y);
                    shipAdder(singleDeckShip);
                    count++;
                }
            }
        }
        count = 0;
        getPlayingField(playingField);
    }

    private static void addDoubleDeckShip() {
        while (count < 3) {
            scanner = new Scanner(System.in);
            switch (count) {
                case 0 -> System.out.println("Введите координаты первого двухпалубного корабля: ");
                case 1 -> System.out.println("Введите координаты второго двухпалубного корабля: ");
                case 2 -> System.out.println("Введите координаты третьего двухпалубного корабля: ");
                default -> System.out.println("Количество однопалубных кораблей должно быть 3");
            }
            String str = scanner.next();
            if (Ships.regexMatching(str, 2)) {
                String[] twoCoordinates = str.split(";");
                System.out.println(Arrays.toString(twoCoordinates));
                List<Integer> coordinate = new ArrayList<>();
                for (String coordinates : twoCoordinates) {
                    String[] array = coordinates.split(",");
                    coordinate.add(Integer.parseInt(array[0]));
                    coordinate.add(Integer.parseInt(array[1]));
                }
                if (creatorArrays(coordinate)) {
                    if (playingField[coordinate.get(0)][coordinate.get(1)].contains(Ships.getDefaultValue()) &&
                            playingField[coordinate.get(2)][coordinate.get(3)].contains(Ships.getDefaultValue())) {
                        doubleDeckShip = new DoubleDeckShip(coordinate.get(0), coordinate.get(1), coordinate.get(2), coordinate.get(3));
                        shipAdder(doubleDeckShip);

                        count++;
                    }
                }
            }
        }
        count = 0;
        getPlayingField(playingField);
    }

    private static void addTripleDeckShip() {
        while (count < 2) {
            scanner = new Scanner(System.in);
            switch (count) {
                case 0 -> System.out.println("Введите координаты первого трёхпалубного корабля: ");
                case 1 -> System.out.println("Введите координаты второго трёхпалубного корабля: ");
                default -> System.out.println("Количество однопалубных кораблей должно быть 2");
            }
            String str = scanner.next();
            if (Ships.regexMatching(str, 3)) {
                String[] twoCoordinates = str.split(";");
                System.out.println(Arrays.toString(twoCoordinates));
                List<Integer> coordinate = new ArrayList<>();
                for (String coordinates : twoCoordinates) {
                    String[] array = coordinates.split(",");
                    coordinate.add(Integer.parseInt(array[0]));
                    coordinate.add(Integer.parseInt(array[1]));
                }
                if (creatorArrays(coordinate)) {
                    if (playingField[coordinate.get(0)][coordinate.get(1)].contains(Ships.getDefaultValue()) &&
                            playingField[coordinate.get(2)][coordinate.get(3)].contains(Ships.getDefaultValue()) &&
                            playingField[coordinate.get(4)][coordinate.get(5)].contains(Ships.getDefaultValue())) {
                        tripleDeckShip = new TripleDeckShip(coordinate.get(0), coordinate.get(1), coordinate.get(2), coordinate.get(3), coordinate.get(4), coordinate.get(5));
                        shipAdder(tripleDeckShip);
                        count++;
                    }
                }
            }
        }
        count = 0;
        getPlayingField(playingField);
    }

    private static void addQuadDeckShip() {
        while (count < 1) {
            scanner = new Scanner(System.in);
            if (count == 0) System.out.println("Введите координаты первого четырёхпалубного корабля: ");
            else System.out.println("Количество однопалубных кораблей должно быть 1");

            String str = scanner.next();
            if (Ships.regexMatching(str, 4)) {
                String[] twoCoordinates = str.split(";");
                System.out.println(Arrays.toString(twoCoordinates));
                List<Integer> coordinate = new ArrayList<>();
                for (String coordinates : twoCoordinates) {
                    String[] array = coordinates.split(",");
                    coordinate.add(Integer.parseInt(array[0]));
                    coordinate.add(Integer.parseInt(array[1]));
                }
                if (creatorArrays(coordinate)) {
                    if (playingField[coordinate.get(0)][coordinate.get(1)].contains(Ships.getDefaultValue()) &&
                            playingField[coordinate.get(2)][coordinate.get(3)].contains(Ships.getDefaultValue()) &&
                            playingField[coordinate.get(4)][coordinate.get(5)].contains(Ships.getDefaultValue()) &&
                            playingField[coordinate.get(6)][coordinate.get(7)].contains(Ships.getDefaultValue())
                    ) {
                        quadDeckShip = new QuadDeckShip(coordinate.get(0), coordinate.get(1), coordinate.get(2), coordinate.get(3), coordinate.get(4), coordinate.get(5), coordinate.get(6), coordinate.get(7));
                        shipAdder(quadDeckShip);

                        count++;
                    }
                }
            }
        }
        count = 0;
        getPlayingField(playingField);
    }

    private static void shipAdder(Ships ship) {
        for (int[] coordinate : ship.getCoordinate()) {
            int x = coordinate[0];
            int y = coordinate[1];
            playingField[x][y] = Ships.getShipValue();

            for (int[] area : ship.getArea()) {
                int areaX = area[0];
                int areaY = area[1];
                playingField[areaX][areaY] = Ships.getArealValue();
            }
        }
    }

    private static boolean creatorArrays(List<Integer> coordinate) {
        arrayX = new ArrayList<>();
        arrayY = new ArrayList<>();

        for (int i = 0; i < coordinate.size(); i++) {
            if (i % 2 == 0) {
                arrayX.add(coordinate.get(i));
            } else arrayY.add(coordinate.get(i));
        }

        return checker(arrayX) && checker(arrayY);
    }

    private static boolean checker(List<Integer> coordinate) {
        boolean check = false;

        for (int i = 1; i < coordinate.size(); i++) {
            if (coordinate.get(i) == coordinate.get(i - 1)) {
                check = true;
            } else check = (coordinate.get(i - 1) == (coordinate.get(i) - 1)) ||
                    (i < coordinate.size() - 1 && (coordinate.get(i - 1) == (coordinate.get(i) + 1)));
        }

        return check;
    }
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


//            for (int i = 2; i < coordinate.size(); i++) {
//                if (i % 2 == 0) {
//                    if (coordinate.get(i) == coordinate.get((i - 2 + coordinate.size())%coordinate.size())) {
//                        if (i == 2) {
//                            arrayX.add(coordinates[0]);
//                        }
//                        arrayX.add(coordinates[i]);
//                        for (int j = 1; j < coordinates.length; j++) {
//                            if (j % 2 != 0) {
//                                if ((coordinates[j] == (coordinates[j - 1] + 1)) ||
//                                        (coordinates[j] == (coordinates[j - 1] - 1))) {
//                                    arrayY.add(coordinates[j]);
//                                } else check = false;
//                            }
//                        }
//                    } else check = false;
//                } else {
//                    if (coordinates[i] == coordinates[i - 2]) {
//                        if (i == 3) {
//                            arrayY.add(coordinates[1]);
//                        }
//                        arrayY.add(coordinates[i]);
//                        //x
//                    } else {
//                        check = false;
//                    }
//                }
//            }


