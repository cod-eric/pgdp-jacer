package oepnv;

import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.SBahnLineNumber;
import oepnv.linenumbers.UBahnLineNumber;
import oepnv.stations.*;

import static oepnv.stations.B690Station.*;

public abstract class Line {
    protected LineNumber lineNumber;
    protected Station to;
    protected Station[] stations;

    public Line(LineNumber lineNumber, Station to) {
        this.lineNumber = lineNumber;
        this.to = to;
        this.stations = initStations();
    }

    private Station[] initStations() {
        if (lineNumber instanceof BusLineNumber b) {
            return switch (b) {
                case B292 -> B292Stations.values();
                case B230 -> B230Station.values();
                case B690 -> new Station[]{
                        // Bus 690 unfortunately drives some loops on its route;
                        // thus we cannot simply return .values here
                        ECHING_OST, ECHING_BLUETENSTRASSE, ECHING_BAHNHOFSTRASSE, ECHING_OTTOSTRASSE,
                        ECHING_HOTEL_OLYMP, ECHING_SCHLESIERSTRASSE, ECHING_OST
                };
                case X201 -> X201Station.values();
                case X660 -> X660Station.values();
            };
        } else if (lineNumber instanceof UBahnLineNumber u) {
            return switch (u) {
                case U2 -> U2Station.values();
                case U3 -> U3Station.values();
                case U6 -> U6Station.values();
            };
        } else if (lineNumber instanceof SBahnLineNumber s) {
            return switch (s) {
                case S1 -> S1Station.   //TODO: (auch in Aufgabenbeschreibung, UML): anhand to bestimmen, welche stations es sind
            }
        }
    }
}
