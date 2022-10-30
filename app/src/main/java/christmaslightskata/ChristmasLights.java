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
        applyFunction(
            new LightBulbLocation(startRow, startCol),
            new LightBulbLocation(endRow, endCol),
            onFunction);

    }

    public void turnOff(int startRow, int startCol, int endRow, int endCol) {
        BiFunction<Integer, Integer, Void> offFunction = (i, j) -> {
            if (lightIsOn[i][j]) {
                lightIsOn[i][j] = false;
                lightsOnCount--;
            }
            return null;
        };
        applyFunction(
            new LightBulbLocation(startRow, startCol),
            new LightBulbLocation(endRow, endCol),
            offFunction);
    }

    public void toggle(int startRow, int startCol, int endRow, int endCol) {
        BiFunction<Integer, Integer, Void> toggleFunction = (i, j) -> {
            lightsOnCount += lightIsOn[i][j] ? -1 : 1;
            lightIsOn[i][j] = !lightIsOn[i][j];
            return null;
        };

        applyFunction(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                toggleFunction);
    }

    private void applyFunction(
            LightBulbLocation topLeft,
            LightBulbLocation bottomRight,
            BiFunction<Integer, Integer, Void> function) {
        for (int i = topLeft.getRow(); i <= bottomRight.getRow(); i++) {
            for (int j = topLeft.getCol(); j <= bottomRight.getCol(); j++) {
                function.apply(i, j);
            }
        }

    }

}
