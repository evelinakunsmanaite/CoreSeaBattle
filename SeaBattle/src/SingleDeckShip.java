import java.util.regex.Pattern;

public class SingleDeckShip extends Ships{
    private int x, y;
    //абстрактный класс должен содержать getIcon

    public SingleDeckShip(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void createArea(int[] coordinate){

    }

}
