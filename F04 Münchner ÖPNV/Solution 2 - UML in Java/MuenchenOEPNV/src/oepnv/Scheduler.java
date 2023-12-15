package oepnv;

import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.SBahnLineNumber;
import oepnv.linenumbers.UBahnLineNumber;

import java.util.*;

import static oepnv.Station.*;

public class Scheduler extends OEPNVEmployee implements MakeAnnouncements {
    public Scheduler(String name, int age, int salary) {
        super(name, age, salary);
    }

    @Override
    public void strike() {
        System.out.println(name + ": I am on strike! Who cares about the net plans?");
    }

    public String createNetPlan(LineNumber[] linesInMunich, TrackSegment[] trackSegments) {
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (LineNumber l : linesInMunich) {
            sb.append(l).append(": -START- ");
            for (int i = 0; i < random.nextInt(trackSegments.length); i++) {
                sb.append(Arrays.toString(trackSegments[i].getCoordinates())).append(", ");
            }
            sb.append(" -END-\n");
        }
        return sb.toString();
    }

    public LineNumber establishReplacementService(LineNumber l) {
        Random random = new Random();
        System.out.println("Due to a delay on line " + l + ", we will establish a bus replacement.");
        return BusLineNumber.values()[random.nextInt(BusLineNumber.values().length)];
    }

    public static List<Station> getStations(LineNumber lineNumber, Station from, Station to) {
        List<Station> stations = new ArrayList<>();
        if (lineNumber instanceof BusLineNumber b) {
            switch (b) {
                case B292 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            GARCHING_FORSCHUNGSZENTRUM, GARCHING_LICHTENBERGSTRASSE,
                            GARCHING_BOLTZMANNSTRASSE, GARCHING_LUDWIG_PRANDTL_STRASSE,
                            GARCHING_LEHRER_STIEGLITZ_STRASSE, GARCHING, GARCHING_MAIER_LEIBNITZ_STRASSE,
                            GARCHING_KELTENWEG, GARCHING_PARKRING_SUED, GARCHING_PARKRING_WEST,
                            GARCHING_DAIMLERSTRASSE, GARCHING_HOCHBRUECK, GARCHING_GEWERBEGEBIET,
                            HOCHBRUECK_VOITHSTRASSE, HOCHBRUECK_CARL_VON_LINDE_STRASSE,
                            HOCHBRUECK_HOHE_BRUECKEN_STRASSE, LUSTHEIM, OBERSCHLEISSHEIM_SCHLOSS,
                            OBERSCHLEISSHEIM_MITTENHEIMER_STRASSE, OBERSCHLEISSHEIM,
                            OBERSCHLEISSHEIM_AM_STUTENANGER, OBERSCHLEISSHEIM_ST_MARGARETHEN_STRASSE,
                            OBERSCHLEISSHEIM_VETERINAERSTRASSE, OBERSCHLEISSHEIM_SONNENSTRASSE
                    ));
                    if (to == OBERSCHLEISSHEIM_SONNENSTRASSE) {
                        Collections.reverse(stations);
                    }
                }
                case B230 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            ISMANING, ISMANING_GEROLDSTRASSE, ISMANING_OSTERFELDSTRASSE,
                            ISMANING_MAX_VON_EYTH_STRASSE, GARCHING_WASSERTURMSTRASSE, GARCHING_AUWEG, GARCHING,
                            GARCHING_LEHRER_STIEGLITZ_STRASSE, GARCHING_UNTERE_STRASSAECKER,
                            GARCHING_LUDWIG_PRANDTL_STRASSE, GARCHING_BOLTZMANNSTRASSE, GARCHING_FORSCHUNGSZENTRUM
                    ));
                    if (to == ISMANING) {
                        Collections.reverse(stations);
                    }
                }
                case B690 -> {
                    if (to == GARCHING_FORSCHUNGSZENTRUM) {
                        stations = new ArrayList<>(Arrays.asList(
                                // Bus 690 unfortunately drives some loops on its route;
                                // thus we cannot simply return .values here
                                ECHING_OST, ECHING_BLUETENSTRASSE, ECHING_BAHNHOFSTRASSE, ECHING_OTTOSTRASSE,
                                ECHING_HOTEL_OLYMP, ECHING_SCHLESIERSTRASSE,    // first loop

                                ECHING_OST, ECHING_OHMSTRASSE, ECHING_LIEBIGSTRASSE, ECHING_FRAUNHOFERSTRASSE,
                                ECHING_OSKAR_VON_MILLER_STRASSE, NEUFAHRN_ZEPPELINSTRASSE, NEUFAHRN_CHRISTL_CRANZ_STRASSE,

                                NEUFAHRN_BAHNHOFSTRASSE, NEUFAHRN_RATHAUS, NEUFAHRN, NEUFAHRN_RATHAUS,  // second loop
                                NEUFAHRN_BAHNHOFSTRASSE, NEUFAHRN_ALTE_KIRCHE, NEUFAHRN_LENA_CHRIST_STRASSE,
                                NEUFAHRN_LISE_MEITNER_STRASSE, DIETERSHEIM_ECHINGER_STRASSE, GARCHING_LUDWIG_PRANDTL_STRASSE,
                                GARCHING_BOLTZMANNSTRASSE, GARCHING_FORSCHUNGSZENTRUM
                        ));
                    } else {
                        stations = new ArrayList<>(Arrays.asList(
                                // on the way to Eching, 690 drives by Lichtenbergstraße, but doesn't on the way towards
                                // Garching Forschungszentrum
                                GARCHING_FORSCHUNGSZENTRUM, GARCHING_LICHTENBERGSTRASSE, DIETERSHEIM_ECHINGER_STRASSE,
                                NEUFAHRN_LISE_MEITNER_STRASSE, NEUFAHRN_LENA_CHRIST_STRASSE, NEUFAHRN_ALTE_KIRCHE,
                                NEUFAHRN_BAHNHOFSTRASSE, NEUFAHRN_RATHAUS, NEUFAHRN, NEUFAHRN_RATHAUS, NEUFAHRN_BAHNHOFSTRASSE,
                                NEUFAHRN_CHRISTL_CRANZ_STRASSE, NEUFAHRN_ZEPPELINSTRASSE, ECHING_OSKAR_VON_MILLER_STRASSE,
                                ECHING_FRAUNHOFERSTRASSE, ECHING_LIEBIGSTRASSE, ECHING_OHMSTRASSE, ECHING_OST
                        ));
                    }
                }
                case X201 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            DACHAU_BAHNHOF, OBERSCHLEISSHEIM_REGATTAANLAGE, OBERSCHLEISSHEIM_VETERINAERSTRASSE,
                            HOCHBRUECK_VOITHSTRASSE, GARCHING_HOCHBRUECK, GARCHING_FORSCHUNGSZENTRUM
                    ));
                    if (to == DACHAU_BAHNHOF) {
                        Collections.reverse(stations);
                    }
                }
                case X660 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            FREISING_WEIHENSTEPHAN, FREISING, FREISING_SCHLUETERSTRASSE,
                            ACHERING_ACHERINGER_HAUPTSTRASSE, MINTRACHING_MUENCHNER_STRASSE, DIETERSHEIM_AUWEG,
                            GARCHING_FORSCHUNGSZENTRUM
                    ));
                    if (to == FREISING_WEIHENSTEPHAN) {
                        Collections.reverse(stations);
                    }
                }
            }
        } else if (lineNumber instanceof UBahnLineNumber u) {
            switch (u) {
                case U2 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            FELDMOCHING, HASENBERGL, DUELFERSTRASSE, HARTHOF, AM_HART, FRANKFURTER_RING,
                            MILBERTSHOFEN, SCHEIDPLATZ, HOHENZOLLERNPLATZ, JOSEPHSPLATZ, THERESIENSTRASSE,
                            KOENIGSPLATZ, HAUPTBAHNHOF, SENDLINGER_TOR, FRAUNHOFERSTRASSE, KOLUMBUSPLATZ,
                            SILBERHORNSTRASSE, UNTERSBERGSTRASSE, GIESING, KARL_PREIS_PLATZ, INNSBRUCKER_RING,
                            JOSEPHSBURG, KREILLERSTRASSE, TRUDERING, MOOSFELD, MESSESTADT_WEST, MESSESTADT_OST
                    ));
                    if (to == FELDMOCHING) {
                        Collections.reverse(stations);
                    }
                }
                case U3 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            MOOSACH, MOOSACHER_ST_MARTINS_PLATZ, OLYMPIA_EINKAUFSZENTRUM, OBERWIESENFELD,
                            OLYMPIAZENTRUM, PETUELRING, SCHEIDPLATZ, BONNER_PLATZ, MUENCHNER_FREIHEIT,
                            GISELASTRASSE, UNIVERSITAET, ODEONSPLATZ, MARIENPLATZ, SENDLINGER_TOR, GOETHEPLATZ,
                            POCCISTRASSE, IMPLERSTRASSE, BRUDERMUEHLSTRASSE, THALKIRCHEN, OBERSENDLING,
                            AIDENBACHSTRASSE, MACHTLFINGER_STRASSE, FORSTENRIEDER_ALLEE, BASLER_STRASSE,
                            FUERSTENRIED_WEST
                    ));
                    if (to == MOOSACH) {
                        Collections.reverse(stations);
                    }
                }
                case U6 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            GARCHING_FORSCHUNGSZENTRUM, GARCHING, GARCHING_HOECHBRUECK, FROETTMANING,
                            KIEFERNGARTEN, FREIMANN, STUDENTENSTADT, ALTE_HEIDE, NORDFRIEDHOF, DIETLINDENSTRASSE,
                            MUENCHNER_FREIHEIT, GISELASTRASSE, UNIVERSITAET, ODEONSPLATZ, MARIENPLATZ,
                            SENDLINGER_TOR, GOETHEPLATZ, POCCISTRASSE, IMPLERSTRASSE, HARRAS, PARTNACHPLATZ,
                            WESTPARK, HOLZAPFELKREUTH, HADERNER_STERN, GROSSHADERN, KLINIKUM_GROSSHADERN
                    ));
                    if (to == GARCHING_FORSCHUNGSZENTRUM) {
                        Collections.reverse(stations);
                    }
                }
            }
        } else if (lineNumber instanceof SBahnLineNumber s) {
            switch (s) {
                case S1 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            NEUFAHRN, ECHING, LOHHOF, UNTERSCHLEISSHEIM, OBERSCHLEISSHEIM, FELDMOCHING,
                            FASANERIE, MOOSACH, LAIM, HIRSCHGARTEN, DONNERSBERGERBRUECKE, HACKERBRUECKE,
                            HAUPTBAHNHOF, KARLSPLATZ_STACHUS, MARIENPLATZ, ISARTOR, ROSENHEIMER_PLATZ,
                            OSTBAHNHOF, LEUCHTENBERGRING
                    ));
                    if (to == FLUGHAFEN_MUENCHEN) {
                        Collections.reverse(stations);
                        stations.add(FLUGHAFEN_BESUCHERPARK);
                        stations.add(FLUGHAFEN_MUENCHEN);
                    } else if (from == FLUGHAFEN_MUENCHEN) {
                        stations.add(0, FLUGHAFEN_BESUCHERPARK);
                        stations.add(0, FLUGHAFEN_MUENCHEN);
                    } else if (to == FREISING) {
                        Collections.reverse(stations);
                        stations.add(PULLING);
                        stations.add(FREISING);
                    } else if (from == FREISING) {
                        stations.add(0, PULLING);
                        stations.add(0, FREISING);
                    } else {
                        throw new IllegalStateException("S1 can only go between FLUGHAFEN/FREISING and LEUCHTENBERGRING.");
                    }
                }
                case S8 -> {
                    stations = new ArrayList<>(Arrays.asList(
                            FLUGHAFEN_MUENCHEN, FLUGHAFEN_BESUCHERPARK, HALLBERGMOOS, ISMANING, UNTERFOEHRING,
                            JOHANNESKIRCHEN, ENGLSCHALKING, DAGLFING, LEUCHTENBERGRING, OSTBAHNHOF,
                            ROSENHEIMER_PLATZ, ISARTOR, MARIENPLATZ, KARLSPLATZ_STACHUS, HAUPTBAHNHOF,
                            HACKERBRUECKE, DONNERSBERGERBRUECKE, HIRSCHGARTEN, LAIM, PASING, WESTKREUZ,
                            NEUAUBING, FREIHAM, HARTHAUS, GERMERING_UNTERPFAFFENHOFEN, GEISENBRUNN,
                            GILCHING_ARGELSRIED, NEUGILCHING, WESSLING, STEINEBACH, SEEFELD_HECHENDORF, HERRSCHING
                    ));
                    if (to == FLUGHAFEN_MUENCHEN) {
                        Collections.reverse(stations);
                    }
                }
            }
        } else {
            throw new IllegalStateException("Mismatch either on Line, from or to");
        }
        return stations;
    }
}
