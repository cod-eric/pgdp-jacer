package oepnv;

public interface Station {
    default boolean equals(Station otherStation) {
        if (this.toString().equals(otherStation.toString())) {
            return true;
        }
        return false;
    }
    default boolean isIn(Station otherStation) {
        // we consider any (bus) station that is in the same town to be close enough to walk to
        // (e.g. "ECHING_OST" is in Eching, just like "ECHING_HOTEL_OLYMP"
        if (this.toString().equals(otherStation.toString())) {
            return true;
        } else {
            return this.toString().split("_")[0].equals(otherStation.toString().split("_")[0]);
        }
    }
}
