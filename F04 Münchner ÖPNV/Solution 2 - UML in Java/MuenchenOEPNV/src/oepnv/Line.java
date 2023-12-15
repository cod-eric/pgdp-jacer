package oepnv;

import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.UBahnLineNumber;
import oepnv.linenumbers.SBahnLineNumber;

import static oepnv.Station.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Line {
    protected LineNumber lineNumber;
    protected Station to;
    protected Station from;
    protected List<Station> stations;

    public Line(LineNumber lineNumber, Station from, Station to) {
        this.lineNumber = lineNumber;
        this.from = from;
        this.to = to;
        this.stations = Scheduler.getStations(lineNumber, from, to);
    }

    public List<Station> getStations() {
        return stations;
    }
}
