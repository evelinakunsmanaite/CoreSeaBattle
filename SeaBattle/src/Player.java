import java.util.*;

public class Player {
    private String name;
    PlayingField playingFieldThis = new PlayingField();
    String[][] playingFieldArray;
    String shot = "\uD83D\uDFE9";

    //регулярное выражение ввода цифра, цифра; ...
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void playingFieldCreate() {
        System.out.println("\nЭто ваше поле, вам нужно расставить корабли в соответствии с правилами игры");
        playingFieldThis.playingFieldCreator();
    }

    public PlayingField getPlayingField() {
        return playingFieldThis;
    }


    public boolean shoot(int x, int y, PlayingField playingField) {
        boolean kill = false;
        playingFieldArray = playingField.getPlayingField();
        playingFieldArray[x][y] = shot;
        if (!(Objects.equals(playingFieldArray[x][y], Ships.getShipValue()))) {
            System.out.println("Мимо");
        } else {
            if (Objects.equals(playingFieldArray[x + 1][y], Ships.getArealValue()) ||
                    Objects.equals(playingFieldArray[x][y + 1], Ships.getArealValue()) ||
                    (x !=0 && Objects.equals(playingFieldArray[x - 1][y], Ships.getArealValue()) ) ||
                    (y !=0 && Objects.equals(playingFieldArray[x][y-1], Ships.getArealValue()) )) {
                System.out.println("Убил");
                kill = true;

            }else {
                System.out.println("Попал");
                kill = true;
            }
        }
        return kill;
    }


    @Override
    public String toString() {
        return "Имя игрока: " + name;
    }
}
