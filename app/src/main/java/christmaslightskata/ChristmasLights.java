package christmaslightskata;

import java.util.function.BiFunction;

public class ChristmasLights {

    private boolean[][] lightIsOn = new boolean[1000][1000];

    private int lightsOnCount = 0;

    public int getNumberOfLightsOn() {
        return lightsOnCount;
    }

    public void turnOn(int startRow, int startCol, int endRow, int endCol) {
        BiFunction<Integer, Integer, Void> onFunction = (i, j) -> {
            if (!lightIsOn[i][j]) {
                lightIsOn[i][j] = true;
                lightsOnCount++;
            }
            return null;
        };
        applyFunction(startRow, startCol, endRow, endCol, onFunction);

    }

    public void turnOff(int startRow, int startCol, int endRow, int endCol) {
        BiFunction<Integer, Integer, Void> offFunction = (i, j) -> {
            if (lightIsOn[i][j]) {
                lightIsOn[i][j] = false;
                lightsOnCount--;
            }
            return null;
        };

        applyFunction(startRow, startCol, endRow, endCol, offFunction);
    }

    private void applyFunction(
            int startRow,
            int startCol,
            int endRow,
            int endCol,
            BiFunction<Integer, Integer, Void> function) {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                function.apply(i, j);
            }
        }
    }

}
