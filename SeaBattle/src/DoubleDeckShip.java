import java.util.*;

public class DoubleDeckShip extends Ships {
    private int x1, y1, x2, y2;
    private int[][] doubleDeckShipArray;
    private List<int[]> areaList;


    public DoubleDeckShip(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        doubleDeckShipArray = new int[][]{{x1, y1}, {x2, y2}};
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    int[][] getCoordinate() {
        return doubleDeckShipArray;
    }

    public void setArea() {
        areaList = new ArrayList<>();
        Set<int[]> shipCoordinatesSet = new HashSet<>();
        Collections.addAll(shipCoordinatesSet, doubleDeckShipArray);

        for (int[] coordinate : doubleDeckShipArray) {
            int x = coordinate[0];
            int y = coordinate[1];

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if ((i >= 0 && j >= 0) && (i < 10 && j < 10)) {
                        if (i != x || j != y) {
                            int[] area = {i, j};
                            areaList.add(area);
                        }

                    }
                }
            }
        }
    }

    public List<int[]> getArea() {
        return areaList;
    }
}
