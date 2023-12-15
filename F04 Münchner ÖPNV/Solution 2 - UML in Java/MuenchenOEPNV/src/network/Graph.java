package network;

import oepnv.Line;
import oepnv.LineNumber;
import oepnv.Scheduler;
import oepnv.Station;
import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.SBahnLineNumber;
import oepnv.linenumbers.UBahnLineNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private final LineNumber[] lineNumberAsIndexes = {
            BusLineNumber.B230, BusLineNumber.B292, BusLineNumber.B690, BusLineNumber.X201, BusLineNumber.X660,
            UBahnLineNumber.U2, UBahnLineNumber.U3, UBahnLineNumber.U6,
            SBahnLineNumber.S1, SBahnLineNumber.S8
    };

    private final List<Boolean>[] stationsAndLineNumbers;

    public Graph() {
        stationsAndLineNumbers = new List[157];
        for (int i = 0; i < stationsAndLineNumbers.length; i++) {
            stationsAndLineNumbers[i] = new ArrayList<>(10);
        }
    }

    public void init(Triple<LineNumber, Station, Station>[] knownConnections) {
        for (Triple<LineNumber, Station, Station> t : knownConnections) {
            List<Station> stationsOnLine = Scheduler.getStations(t.getA(), t.getB(), t.getC());
            for (Station s : stationsOnLine) {
                stationsAndLineNumbers[s.ordinal()].set(getIndexOfLineNumber(t.getA()), true);
            }
        }
    }

    public boolean doesLineStopAt(LineNumber ln, Station s) {
        return stationsAndLineNumbers[s.ordinal()].get(getIndexOfLineNumber(ln));
    }

    public List<LineNumber> linesThatStopAt(Station s) {
        List<LineNumber> linesThatStopHere = new ArrayList<>();
        for (LineNumber l : lineNumberAsIndexes) {
            if (doesLineStopAt(l, s)) {
                linesThatStopHere.add(l);
            }
        }
        return linesThatStopHere;
    }

    public List<List<LineNumber>> findAllConnectionsWithoutWalking(Station from, Station to) {
        Set<Station> alreadyVisited = new HashSet<>();

    }

    private List<List<LineNumber>> findAllNoWalkingHelper(
            Station current, Station to, Set<Station> visited, List<LineNumber> currentPath, List<List<LineNumber>> foundConnections) {
        visited.add(current);
        currentPath.add(current);
        if (current == to) {
            currentPath.
        }
        if (visited.contains(current)) {
            return
        }
    }

    private int getIndexOfLineNumber(LineNumber l) {
        for (int i = 0; i < lineNumberAsIndexes.length; i++) {
            if (lineNumberAsIndexes[i] == l) {
                return i;
            }
        }
        return -1;
    }

    public static class Triple<A, B, C> {
        private final A a;
        private final B b;
        private final C c;

        public Triple(A a, B b, C c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        public C getC() {
            return c;
        }
    }

}
