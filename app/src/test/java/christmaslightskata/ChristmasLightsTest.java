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
        christmasLights.turnOn(0, 0, 2, 2);

        assertEquals(9, christmasLights.getNumberOfLightsOn());
    }

    private void turnOnTopLeftLight() {
        christmasLights.turnOn(0,0,0,0);
    }
}
