import oepnv.Station;
//TODO uncomment this once you have implemented LineNumber and its subclasses
/*import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.SBahnLineNumber;
import oepnv.linenumbers.UBahnLineNumber;*/

public class Main {
    //TODO uncomment this once you have implemented LineNumber and its subclasses
    /*static Triple<LineNumber, Station, Station>[] knownConnections = new Triple[]{
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
    };*/

    public static void main(String[] args) {
        //TODO hier könnt ihr eure Miniwelt testen
    }

    /**
     * Hilfsklasse, um die möglichen Verbindungen (knownConnections) zu speichern - hilft euch vielleicht bei eigenen Ideen.
     * @param <A>   type one
     * @param <B>   type two
     * @param <C>   type three
     */
    static class Triple<A, B, C> {
        private A one;
        private B two;
        private C three;

        public Triple(A one, B two, C three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }

        public A getOne() {
            return one;
        }

        public B getTwo() {
            return two;
        }

        public C getThree() {
            return three;
        }
    }
}