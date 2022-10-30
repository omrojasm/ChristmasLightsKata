package christmaslightskata;

public class ChristmasLights {

    private boolean[][] lightIsOn = new boolean[1000][1000];

    private int lightsOnCount = 0;

    public int getNumberOfLightsOn() {
        return lightsOnCount;
    }

    public void turnOn(int startRow, int startCol, int endRow, int endCol) {
        if(!lightIsOn[startRow][startCol]) {
            lightIsOn[startRow][startCol] = true;
            lightsOnCount++;
        }
    }
    
}
