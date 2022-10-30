package christmaslightskata;

public class ChristmasLights {

    private int lightsOnCount = 0;

    public int getNumberOfLightsOn() {
        return lightsOnCount;
    }

    public void turnOn(int startRow, int startCol, int endRow, int endCol) {
        lightsOnCount++;
    }
    
}
