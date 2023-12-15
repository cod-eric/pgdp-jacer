package oepnv;

public class TrackSegment {
    private Vehicle trackType;
    private double width;
    private double length;
    private double[] coordinates;

    public TrackSegment(Vehicle trackType, double width, double length, double[] coordinates) {
        this.trackType = trackType;
        this.width = width;
        this.length = length;
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public static boolean vehicleCanUseSegment(Vehicle v, TrackSegment segment) {
        return v.getClass() == segment.trackType.getClass();
    }
}
