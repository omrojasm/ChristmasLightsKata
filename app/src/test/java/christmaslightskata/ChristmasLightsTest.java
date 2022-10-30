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

    private void turnOnTopLeftLight() {
        christmasLights.turnOn(0,0,0,0);
    }
}
