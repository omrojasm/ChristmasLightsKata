package christmaslightskata;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChristmasLights {

    private LightBulb[][] lights;

    private Map<String, Operation> operations;

    public ChristmasLights() {
        final int GRID_ROW_COL_SIZE = 1000;

        lights = new LightBulb[GRID_ROW_COL_SIZE][GRID_ROW_COL_SIZE];
        range(0, GRID_ROW_COL_SIZE).forEach(
                row -> range(0, GRID_ROW_COL_SIZE).forEach(
                        col -> lights[row][col] = new LightBulb()));

        operations = new HashMap<String, Operation>() {
            {
                put("on", (i, j) -> lights[i][j].turnOn());
                put("off", (i, j) -> lights[i][j].turnOff());
                put("toggle", (i, j) -> lights[i][j].toggle());
            }
        };

    }

    public int getNumberOfLightsOn() {
        return (int) stream(lights)
                .flatMap(Arrays::stream)
                .filter(LightBulb::isOn)
                .count();
    }

    public void turnOn(int startRow, int startCol, int endRow, int endCol) {

        applyOperation(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                operations.get("on"));

    }

    public void turnOff(int startRow, int startCol, int endRow, int endCol) {

        applyOperation(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                operations.get("off"));
    }

    public void toggle(int startRow, int startCol, int endRow, int endCol) {

        applyOperation(
                new LightBulbLocation(startRow, startCol),
                new LightBulbLocation(endRow, endCol),
                operations.get("toggle"));
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
