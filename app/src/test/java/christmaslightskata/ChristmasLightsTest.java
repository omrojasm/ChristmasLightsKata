package christmaslightskata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChristmasLightsTest {

    @Test
    void shouldStartWithAllLightsOff() {
        var christmasLights = new ChristmasLights();

        assertEquals(0, christmasLights.getNumberOfLightsOn());
    }
}
