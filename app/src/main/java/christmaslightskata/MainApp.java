package christmaslightskata;

import static java.lang.String.format;

public class MainApp {

    public static void main(String[] args) {
        var christmasLights = new ChristmasLights();

        christmasLights.turnOn(887, 9, 959, 629);
        christmasLights.turnOn(445, 398, 844, 448);
        christmasLights.turnOff(539, 243, 559, 965);
        christmasLights.turnOff(370, 819, 676, 868);
        christmasLights.turnOff(145, 40, 370, 997);
        christmasLights.turnOff(301, 3, 808, 453);
        christmasLights.turnOn(351, 678, 951, 908);
        christmasLights.toggle(720, 196, 897, 994);
        christmasLights.toggle(831, 394, 904, 860);

        var answer = christmasLights.getNumberOfLightsOn();

        System.out.println(format("Number of lights that are lit: %d", answer));
    }

}