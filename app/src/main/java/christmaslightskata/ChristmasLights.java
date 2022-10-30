package christmaslightskata;

public class ChristmasLights {

    private boolean[][] lightIsOn = new boolean[1000][1000];

    private int lightsOnCount = 0;

    public int getNumberOfLightsOn() {
        return lightsOnCount;
    }

    public void turnOn(int startRow, int startCol, int endRow, int endCol) {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (!lightIsOn[i][j]) {
                    lightIsOn[i][j] = true;
                    lightsOnCount++;
                }
            }
        }
    }

}
