package oepnv;

public class SwitchSegment extends TrackSegment {
    private boolean isSwitched;

    public SwitchSegment(LineNumber trackType, double width, double length, double[] coordinates) {
        super(trackType, width, length, coordinates);
    }

    public void flipSwitch() {
        isSwitched = !isSwitched;
    }

    public boolean isSwitched() {
        return isSwitched;
    }
}
