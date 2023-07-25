import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;

    //регулярное выражение ввода цифра, цифра; ...
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void playingFieldCreate(){
        System.out.println("\nЭто ваше поле, вам нужно расставить корабли в соответствии с правилами игры");
        PlayingField.playingFieldCreator();
    }


    @Override
    public String toString() {
        return "Имя игрока: " + name;
    }
}
