import java.util.*;

public class QuadDeckShip extends Ships {
    private int x1, y1, x2, y2, x3, y3, x4, y4;
    private int[][] quadDeckShipArray;
    private List<int[]> areaList;

    public QuadDeckShip(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        quadDeckShipArray = new int[][]{{x1, y1}, {x2, y2}, {x3, y3}, {x4, y4}};
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

    public int getX3() {
        return x3;
    }

    public int getY3() {
        return y3;
    }

    public int getX4() {
        return x4;
    }

    public int getY4() {
        return y4;
    }

    @Override
    int[][] getCoordinate() {
        return quadDeckShipArray;
    }

    public void setArea() {
        areaList = new ArrayList<>();
        Set<int[]> shipCoordinatesSet = new HashSet<>();
        Collections.addAll(shipCoordinatesSet, quadDeckShipArray);

        for (int[] coordinate : quadDeckShipArray) {
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
