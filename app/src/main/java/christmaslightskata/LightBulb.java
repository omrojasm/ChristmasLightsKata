package christmaslightskata;

public class LightBulb {

    private boolean on;

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void toggle() {
        on = !on;
    }
}
