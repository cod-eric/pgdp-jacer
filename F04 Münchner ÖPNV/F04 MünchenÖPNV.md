# F04: 🚈 MünchenÖPNV

> Diese Aufgabe ist Teil der freiwilligen inoffiziellen Zusatzaufgaben von Eric Jacob und Jonas Wende, erstellt im WS 23/24 für *IN0002: Grundlagenpraktikum Programmierung*.
Weder sind sie durch die ÜL überprüft, noch unbedingt vollständig richtig.
Fehler gerne melden: eric.jacob.2003@gmail.com

[TOC]

## 🎯 Lernziele

Diese Aufgabe dient der Wiederholung folgender Konzepte:

- Klassen
- Vererbung
- Interfaces
- Text zu UML
- UML zu Code



## 📜 Backstory

Da die Pinguine bereits sehr viel Gutes über eure ausgezeichneten Programmierfähigkeiten gehört und in den letzten Wochen an euren H-Aufgaben auch gesehen haben, möchten sie euch vor der 2. bPHA besuchen. München soll ja auch eine tolle Stadt sein, und welcher Pinguin trinkt nicht gerne gelegentlich ein Bier zu seiner Schneeweißwurst? Gerade am Flughafen mit *AntarcticAir* gelandet, wollen sie euch nun am Forschungszentrum besuchen kommen - doch sie haben leider keine Ahnung vom Münchner ÖPNV-Netz. Am besten verstehen die Pinguine UML-Diagramme und Java-Code — kannst du ihnen den MVV also für sie verständlich erklären?



## 📝 Aufgabenbeschreibung

Ziel dieser Aufgabe ist es, Vererbung und UML-Diagramme zu wiederholen. Der tatsächliche Code ist bis auf die äußere Struktur durch Klassen, Vererbung, etc. recht sinnbefreit — seid also gerne kreativ! Insgesamt ist die Beschreibung absichtlich offen gehalten, sodass ihr selbst entscheiden könnt, wie genau ihr bestimmte Funktionalitäten implementiert. Der Lösungsvorschlag ist also genau das - ein **Vorschlag**.

> Eigentlich war der Plan, eure fertige Klassenstruktur mit dem Anfragen der MVG-API zu testen, aber da ihr mit diesen Daten auch nicht viel machen außer anzeigen könntet, haben wir uns dazu entschieden, mehr auf Übung anstatt praktische Anwendung zu setzen — vielleicht kommt das Feature ja noch irgendwann dazu (solltet ihr dazu motiviert sein, erstellt gerne eine Pull Request :) ).

*Lies die folgende Beschreibung am besten erst einmal vollständig durch, bevor du mit der Implementation beginnst.*

Grundlegend ist der Münchner Nahverkehr in unserer Miniwelt in drei Kategorien unterteilt: Mitarbeiter/Passagiere, Fahrzeuge und Straßen/Schienen.

### Mitarbeiter

#### Human

Alle Menschen haben einen Namen und ein Alter — auf beide können auch die "konkreteren" Menschen direkt zugreifen. Zudem können Menschen reden und für eine gegeben Dauer schlafen. In unserer Miniwelt gibt es keine einfachen "Menschen", lediglich konkretere Einheiten wie `Driver` oder `Passenger`.

#### OEPNVEmployee

Jeder Mitarbeiter des ÖPNV hat ein Gehalt, das er jedoch lieber geheim hält. Zudem hat er die Möglichkeit zu streiken — wie genau ein solcher Streik aussieht, hängt jedoch immer vom konkreteren Beruf ab.

#### Driver

Ein Fahrer ist ein `OEPNVEmployee`, kann Announcements machen und besitzt potenziell mehrere `DriversLicense`s, die ihn zum Fahren einer bestimmten Fahrzeugart berechtigen. Zudem kann ein Fahrer selbstverständlich ein Fahrzeug fahren (`drive(Vehicle)`) und die Frage, ob er eine angefragte Art von Fahrzeug fahren darf, mit `true`/`false` beantworten (`isLicensedFor(Line)`).

#### Scheduler

Ein Scheduler kann Netzpläne erstellen (`createNetPlan(Line[], TrackSegment[])`) und gibt den erstellten Netzplan als `String` zurück. Außerdem kann ein Scheduler im Falle einer Störung Schienenersatzverkehr mit Bussen veranlassen (`establishReplacementService(Line): Line`). Dafür muss er die betroffene Linie kennen und gibt die Linie, die den SEV übernimmt, zurück.

#### Hilfsklassen und co

##### DriversLicense

Dieses Enum speichert die möglichen Führerscheine für U-Bahn (`UBahnLicense`), S-Bahn (`SBahnLicense`), Tram (`TramLicense`) und Bus (`BusLicense`), die ein `Driver` haben kann.

##### MakeAnnouncements

Dieses Interface gibt die Methode `announce(String)` vor, welche der Fähigkeit, eine Durchsage machen zu können, entspricht.



## 🪜 Aufgaben

### 1. Text zu UML

Wandle die obige Beschreibung in ein UML-Diagramm um. Dafür kannst du zum Beispiel [Apollon](https://apollon.ase.in.tum.de) verwenden.

### 2. UML zu Code

Erstelle anhand deines UML-Diagramms nun die entsprechenden Java-Klassen und implementiere diese korrekt.



## 🔍 Lösungsvorschlag

Siehe `Solution 1 - UML Diagram` bzw. `Solution 2 - UML in Java` für die entsprechenden Teilaufgaben.



## 🗃️ Anhang
