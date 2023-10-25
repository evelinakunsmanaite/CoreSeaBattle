import java.util.List;
import java.util.regex.Pattern;

public abstract class Ships {
    private static final String shipValue = "\uD83D\uDEF3️";
    private static final String defaultValue = "\uD83D\uDFE8";
    private static final String arealValue = "\uD83D\uDFE5";

    public static String getShipValue() {
        return shipValue;
    }

    public static String getDefaultValue() {
        return defaultValue;
    }

    public static String getArealValue() {
        return arealValue;
    }

    public static boolean regexMatching(String str, int ship) {
        String regex;
        switch (ship) {
            case 1 -> regex = "[0-9],[0-9]";
            case 2 -> regex = "[0-9],[0-9];[0-9],[0-9]";
            case 3 -> regex = "[0-9],[0-9];[0-9],[0-9];[0-9],[0-9]";
            case 4 -> regex = "[0-9],[0-9];[0-9],[0-9];[0-9],[0-9];[0-9],[0-9]";
            default -> throw new IllegalStateException("Unexpected value: " + ship);// моя ошибка
        }
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(str).matches()) {
            System.out.println("error");
            return false;
        } else return true;
    }

    abstract int[][] getCoordinate();

    abstract void setArea();

    abstract List<int[]> getArea();

}
