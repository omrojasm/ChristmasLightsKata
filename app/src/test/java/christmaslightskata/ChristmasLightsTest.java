package christmaslightskata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasLightsTest {

    private ChristmasLights christmasLights;

    @BeforeEach
    void setUp() {
        christmasLights = new ChristmasLights();
    }

    @Test
    void shouldStartWithAllLightsOff() {

        assertEquals(0, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldTurnOneLightOn() {

        turnOnTopLeftLight();

        assertEquals(1, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldKeepCountWhenTurningOnSameLight() {

        turnOnTopLeftLight();
        turnOnTopLeftLight();

        assertEquals(1, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldTurnOn3By3RangeOfLights() {
        turnOn3By3LightsStartingFromTopLeft();

        assertEquals(9, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldTurnOffOneLight() {
        turnOnTopLeftLight();

        turnOffTopLeftLight();

        assertEquals(0, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldKeepCountWhenTurningOffSameLight() {

        turnOnTopLeftLight();

        turnOffTopLeftLight();
        turnOffTopLeftLight();

        assertEquals(0, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldTurnOff2By2RangeOfLights() {
        turnOn3By3LightsStartingFromTopLeft();

        turnOff2By2LightsStartingFromTopLeft();

        assertEquals(5, christmasLights.getNumberOfLightsOn());

    }

    @Test
    void shouldToggleOffALightThatIsOn() {
        turnOnTopLeftLight();

        toggleTopLeftLight();

        assertEquals(0, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldToggleOnALightThatIsOff() {
        turnOffTopLeftLight();

        toggleTopLeftLight();

        assertEquals(1, christmasLights.getNumberOfLightsOn());
    }

    @Test
    void shouldToggleRangeOffLights() {
        turnOnFirstTwoRows();

        toggleFirstRow();

        assertEquals(1000, christmasLights.getNumberOfLightsOn());
    }

    private void turnOnFirstTwoRows() {
        christmasLights.turnOn(0, 0, 1, 999);
    }

    private void toggleFirstRow() {
        christmasLights.toggle(0, 0, 0, 999);
    }

    private void turnOffTopLeftLight() {
        christmasLights.turnOff(0, 0, 0, 0);
    }

    private void turnOnTopLeftLight() {
        christmasLights.turnOn(0, 0, 0, 0);
    }

    private void turnOn3By3LightsStartingFromTopLeft() {
        christmasLights.turnOn(0, 0, 2, 2);
    }

    private void turnOff2By2LightsStartingFromTopLeft() {
        christmasLights.turnOff(0, 0, 1, 1);
    }

    private void toggleTopLeftLight() {
        christmasLights.toggle(0, 0, 0, 0);
    }
}
