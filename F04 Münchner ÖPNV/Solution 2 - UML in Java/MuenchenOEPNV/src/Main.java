import oepnv.*;
import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.SBahnLineNumber;
import oepnv.linenumbers.UBahnLineNumber;

import java.util.*;

public class Main {
    static Triple<LineNumber, Station, Station>[] knownConnections = new Triple[]{
            new Triple<>(SBahnLineNumber.S1, Station.LEUCHTENBERGRING, Station.FREISING),
            new Triple<>(SBahnLineNumber.S1, Station.LEUCHTENBERGRING, Station.FLUGHAFEN_MUENCHEN),
            new Triple<>(SBahnLineNumber.S1, Station.HERRSCHING, Station.FLUGHAFEN_MUENCHEN),
            new Triple<>(UBahnLineNumber.U2, Station.MESSESTADT_OST, Station.FELDMOCHING),
            new Triple<>(UBahnLineNumber.U3, Station.FUERSTENRIED_WEST, Station.MOOSACH),
            new Triple<>(UBahnLineNumber.U6, Station.KLINIKUM_GROSSHADERN, Station.GARCHING_FORSCHUNGSZENTRUM),
            new Triple<>(BusLineNumber.B292, Station.GARCHING_FORSCHUNGSZENTRUM, Station.OBERSCHLEISSHEIM_SONNENSTRASSE),
            new Triple<>(BusLineNumber.B230, Station.GARCHING_FORSCHUNGSZENTRUM, Station.ISMANING),
            new Triple<>(BusLineNumber.B690, Station.GARCHING_FORSCHUNGSZENTRUM, Station.ECHING_OST),
            new Triple<>(BusLineNumber.X201, Station.GARCHING_FORSCHUNGSZENTRUM, Station.DACHAU_BAHNHOF),
            new Triple<>(BusLineNumber.X660, Station.GARCHING_FORSCHUNGSZENTRUM, Station.FREISING_WEIHENSTEPHAN)
    };

    public static void main(String[] args) {
        System.out.println(stringify(findConnectionsWithoutWalking(Station.ECHING_OST, Station.GARCHING_FORSCHUNGSZENTRUM)));
    }

    private static List<Station> findConnection(Station from, Station to) {
        return null;
    }

    private static List<LineNumber> findConnectionsWithoutWalking(Station from, Station to) {
        List<LineNumber> foundPaths = new ArrayList<>();
        findConnectionsWithoutWalkingHelper(from, to, new ArrayList<>(), foundPaths, new HashSet<>());
        return foundPaths;
    }

    private static List<Station> findConnectionsWithoutWalkingHelper(
            Station current, Station to, List<Station> currentPath, List<LineNumber> currentPaths, Set<Station> seen
    ) {
        currentPath.add(current);
        seen.add(current);
        if (current == to) {
            return currentPath;
        }
        for (Triple<LineNumber, Station, Station> route : knownConnections) {
            // check one direction
            boolean foundFromStation = false;
            for (Station station : Scheduler.getStations(route.a, route.b, route.c)) {
                if (station == current) {
                    foundFromStation = true;
                }
                if (!foundFromStation || seen.contains(station)) {
                    continue;
                }
                List<Station> ret = findConnectionsWithoutWalkingHelper(station, to, currentPath, currentPaths, seen);
                if (ret != null) {
                    currentPaths.add(route.a);
                }
                currentPath.remove(station);
            }

            // check reverse direction
            foundFromStation = false;
            for (Station station : Scheduler.getStations(route.a, route.c, route.b)) {
                if (station == current) {
                    foundFromStation = true;
                }
                if (!foundFromStation || seen.contains(station)) {
                    continue;
                }
                List<Station> ret = findConnectionsWithoutWalkingHelper(station, to, currentPath, currentPaths, seen);
                if (ret != null) {
                    currentPaths.add(route.a);
                }
                currentPath.remove(station);
            }
        }
        return null;
    }

    private static Set<LineNumber> oepnvAtStation(Station s) {
        Set<LineNumber> connectionsAt = new HashSet<>();
        for (Triple<LineNumber, Station, Station> t : knownConnections) {
            if (Scheduler.getStations(t.a, t.b, t.c).contains(s)) {
                connectionsAt.add(t.a);
            }
        }
        return connectionsAt;
    }

    private static String stringify(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object t : list) {
            if (t instanceof List<?> tlist) {
                sb.append(stringify(tlist));
            } else {
                sb.append(t.toString());
            }
            sb.append(" -> ");
        }
        sb.setLength(sb.length()-4);
        sb.append("\n");
        return sb.toString();
    }

    private static class Triple<A, B, C> {
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