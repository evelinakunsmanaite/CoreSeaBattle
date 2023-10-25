import java.util.*;

public class SingleDeckShip extends Ships {
    private int x1, y1;
    private int[][] singleDeckShipArray;
    private List<int[]> areaList;

    public SingleDeckShip(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
        singleDeckShipArray = new int[][]{{x1, y1}};
        setArea();
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    @Override
    int[][] getCoordinate() {
        return singleDeckShipArray;
    }

    public void setArea() {
        areaList = new ArrayList<>();

        for (int[] coordinate : singleDeckShipArray) {
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
