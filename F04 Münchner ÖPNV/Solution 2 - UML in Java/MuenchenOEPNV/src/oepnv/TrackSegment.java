package oepnv;

public class TrackSegment {
    private LineNumber trackType;
    private double width;
    private double length;
    private double[] coordinates;

    public TrackSegment(LineNumber trackType, double width, double length, double[] coordinates) {
        this.trackType = trackType;
        this.width = width;
        this.length = length;
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }
}
