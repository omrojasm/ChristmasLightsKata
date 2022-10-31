package christmaslightskata;

public class ChristmasLights {

    private boolean[][] lightIsOn = new boolean[1000][1000];

    private int lightsOnCount = 0;

    public int getNumberOfLightsOn() {
        return lightsOnCount;
    }

    public void turnOn(int startRow, int startCol, int endRow, int endCol) {

        Operation on = (i, j) -> {
            if (!lightIsOn[i][j]) {
                lightIsOn[i][j] = true;
                lightsOnCount++;
            }
        };

        applyOperation(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                on);

    }

    public void turnOff(int startRow, int startCol, int endRow, int endCol) {

        Operation off = (i, j) -> {
            if (lightIsOn[i][j]) {
                lightIsOn[i][j] = false;
                lightsOnCount--;
            }
        };

        applyOperation(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                off);
    }

    public void toggle(int startRow, int startCol, int endRow, int endCol) {

        Operation toggleOperation = (i, j) -> {
            lightsOnCount += lightIsOn[i][j] ? -1 : 1;
            lightIsOn[i][j] = !lightIsOn[i][j];
        };

        applyOperation(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                toggleOperation);
    }

    private void applyOperation(
            LightBulbLocation topLeft,
            LightBulbLocation bottomRight,
            Operation operation) {
        for (int i = topLeft.getRow(); i <= bottomRight.getRow(); i++) {
            for (int j = topLeft.getCol(); j <= bottomRight.getCol(); j++) {
                operation.apply(i, j);
            }
        }

    }

    @FunctionalInterface
    private interface Operation {
        void apply(Integer row, Integer col);
    }

}
