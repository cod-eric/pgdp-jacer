# F02A02: 🈶 Polylingual Pingu

> Diese Aufgabe ist Teil der freiwilligen inoffiziellen Zusatzaufgaben von Eric Jacob und Jonas Wende, erstellt im WS 23/24 für *IN0002: Grundlagenpraktikum Programmierung*.
> Weder sind sie durch die ÜL überprüft, noch unbedingt vollständig richtig.
> Fehler gerne melden: eric.jacob.2003@gmail.com

> 🎄 *Advent, Advent, ein Server brennt*… oder so. Vorweihnachtlich gibt es jeden Adventssonntag eine freiwillige inoffizielle Zusatzaufgabe, die weit über den Inhalt von PGdP hinausgehen und euch einige Programmierkonzepte zeigen sollen, die ihr so in PGdP nicht lernt.

## 🎯 Lernziele

In dieser Aufgabe lernt ihr einige andere Programmiersprachen neben Java kennen - und, dass ihr die meisten davon mit eurem Java-Wissen verstehen könnt, auch wenn ihr noch nie zuvor in diesen programmiert habt.



## 📜 Backstory

Zur vorweihnachtlichen Tradition der Pinguine gehört seit eh und je der alljährliche Besuch im "Museum für Alles" in Cod-City. Heute, am 02. Adventssonntag, ist es wieder soweit - nach dem gemeinsamen Mittagessen, für welches Pingu-Opa Max seinen berühmten [Lachs mit Spekulatiuskruste](https://www.essen-und-trinken.de/rezepte/59961-rzpt-lachsfilet-mit-spekulatiuskruste) gekocht hat, ging es los ins Museum. In jeder Abteilung fallen den Babypinguinen neben all den antiken Statuen und Zeichnungen besonders die überlieferten Schriftstücke auf, welche in Vitrinen an der Wand hängen. Trotz deren Alter von teils mehreren Jahrhunderten ist die Schrift darauf noch gut erhalten - nur schade, dass die Pinguine die Schriftzeichen nicht entziffern können… Kannst du ihnen helfen?



## 📝 Aufgabenbeschreibung

Ziel dieser Aufgabe ist es, die Ähnlichkeit und Unterschiede zwischen verschiedenen Programmiersprachen zu sehen und Algorithmen in verschiedenen Sprachen umzusetzen.



### 🐍 Abteilung für Würgeschlangen - Python

Neben den ganzen imposanten Terrarien hängt an der Wand hinter einer Glasscheibe folgendes Papyrus der alten Pharaouinen:

```py

```





— # TODO below this line —

## 🧱 Template

Das Template für diese Aufgabe sieht wie folgt aus:
*(✒️ bedeutet, dass du in dieser Methode etwas ändern/ergänzen musst.)*

- ✒️ `runBrainfuckSequence(int[] tape, String code, boolean printAsChars, boolean showSteps)` ist die Hauptmethode - hier iterierst du über die Zeichen des Codes und führst die Befehle auf deinem Band aus.

    - `tape` ist das Datenband in Form eines `int`-Arrays. Beachte, dass dieses zu Beginn beliebig lang sein und auch bereits Daten beinhalten kann.
    - `code` ist der Brainfuck-Code.
    - `printAsChars` gibt an, ob die Ausgaben bei einem `.` in `code` als `int`s oder `char`s dargestellt werden sollen (macht das Debugging leichter).
    - `showSteps` gibt an, ob der aktuelle Ausführungszustand nach jedem ausgeführten Befehl ausgegeben werden soll (siehe Aufgabe Pretty Print weiter unten).

- ✒️ `addPlaceToTape(int[] oldTape, boolean inFront)` verlängert das Band bei Bedarf, indem am linken oder rechten Ende Zellen ergänzt werden. Diese Methode kannst du in `runBrainfuckSequence` nutzen.

    *Kleine Anmerkung: Diese Art der Arrayvergrößerung ist sehr ineffizient - noch kennen wir allerdings nichts besseres. Solange dein Code nicht hundertmal in eine Richtung läuft, sollte das auch kein Problem sein.*

    - `oldTape` ist das aktuelle Band.
    - `inFront` gibt an, ob die zusätzliche Zelle links (front) oder rechts (back bzw. `!inFront`) angefügt werden soll.
    - Rückgabe: das vergrößerte Array

- ✒️ `prettyPrintCode(int[] tape, String code, int posInCode, int posInTape)` gibt den aktuellen Zustand der Turingmaschine in einem leserlichen (und leicht debug-baren) Format aus.

    - `tape` ist das aktuelle Band.

    - `code` ist der Brainfuck-Code.

    - `posInCode` ist die aktuelle Position im Code.

    - `posInTape` ist die aktuelle Position des Kopfs auf dem Band.

- `readCharFromConsole()` ließt das nächste Zeichen von der Konsole und gibt dieses zurück. Diese Methode kannst du in `runBrainfuckSequence` nutzen.

    - Rückgabe: das gelesene Zeichen



## 🪜 Aufgaben

### 1. Bandvergrößerung

Zuerst sollst du `addPlaceToTape()` implementieren. Achte darauf, die Daten des alten Arrays in das neue zu übernehmen und die neue Zelle am richtigen Ende hinzuzufügen.

### 2. Datenspeicherung

Überlege dir nun, wie du in `runBrainfuckSequence()` die aktuelle Position im Code und auf dem Band speichern willst.

Der einfacheren Lesbarkeit halber sollen Leerzeichen im `code` erlaubt sein - für die Abarbeitung des Codes musst du diese jedoch entfernen. Nutze dafür die Methode `.replace("zu ersetzender String", "neuer String")` auf dem entsprechenden String.

### 3. Pretty Print

Nach jedem Befehl aus `code` soll das aktuelle Band und die Zeigerposition wie folgt ausgegeben werden:

````
Step 165:	tape: [1, 0],	instruction: +
			       ^
````

Implementiere dafür die Methode `prettyPrintCode()`.

Überlege dabei, wie du dir die aktuelle Position im Code (welche hinter “Step” steht) und im Array zunutze machen kannst, den Zeiger (`^`) an der richtigen Stelle auszugeben.

*Tipp: Um das Array leicht ausgeben zu können, bietet sich möglicherweise ein Blick in die [Arrays-Library](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html) an.*

*Tipp: Um die Abstände zwischen den einzelnen Komponenten trotz verschieden großer Zahlen hinter “Step” gleich zu behalten, kannst du Tabs printen - das Zeichen dafür ist `\t`.*

### 4. Befehle lesen & verarbeiten

Iteriere nun über die Befehle in `code` und implementiere eine Fallunterscheidung sowie die einfachen Instruktionen (also `+`, `-`, `<`, `>`, `.`, `,`). Achte bei `<` und `>` darauf, dass keine OutOfBounds-Error entstehen und das Band entsprechend vergrößert wird.

### 5. Loops

- Wie kannst du (ohne Rekursion! - nicht auf dumme Gedanken kommen) sicherstellen, beim Überspringen des Schleifencodes im Falle von `currentCell == 0`, an der richtigen Endklammer `]` rauszukommen?
- Wie läufst du bei einem `]` an die richtige zugehörige Startklammer `[` zurück? Achte darauf, bei der Abarbeitung des nächsten Zeichens keines zu überspringen!

Beachte, dass beim Überspringen bzw. Zurücklaufen **keine** Befehle ausgeführt werden sollen!

*Tipp: Es genügt eine primitive Variable.*

### 6. Fehlererkennung

Woran kann man erkennen, dass der Code zu viele öffnende bzw. schließende Klammern enthält? Gib in diesen Fällen, sowie bei unbekannten Zeichen im Programmcode eine Meldung auf der Konsole aus und beende die Ausführung des Programms.



## 🧪 Tests

Für diese Aufgabe gibt es keine automatisierten Tests. Du kannst allerdings mit folgenden Beispielen testen, ob dein Programm die Anforderungen erfüllt.

1. Code: `+ + +`, Tape: `{2}`

    erwartetes Ergebnis: `[5]`

2. Code: `+ + [ > + + > - - - < < - ] >`, Tape: `{}`

    erwartetes Ergebnis: `[0, 4, -6]`

3. Code: `+ + + + + + + + + + [ > + + + + + + > + + + + + + + + + < < - ] > + + . > + + + + + . `, Tape: `{1, 1}`

    erwartetes Ergebnis: Konsole: `Hi`, Tape: `[0, 72, 105]`

4. Code: `+ + [ > + + [ > + + + < - ] < - ]`, Tape: `{}`

    erwartetes Ergebnis: Tape: `[0, 0, 12]`

5. Code: `> + + + + + + + + + [ < + + + + + + + + > - ] < . > + + + + + + + [ < + + + + > - ] < + . + + + + + + + . . + + + . - ] > + + + + + + + + [ < + + + + > - ] < . > + + + + + + + + + + + [ < + + + + + + + + > - ] < - . - - - - - - - - . + + + . - - - - - - . - - - - - - - - . [ - ] > + + + + + + + + [ < + + + + > -   ] < + . [ - ] + + + + + + + + + + .`, Tape: `{}`

    erwartetes Ergebnis: Konsole: `Hello world!`, Tape: `[10, 0]`



## 🗃️ Anhang

### Das Spekulatius-Lachs-Rezept von Pingu-Opa Max

https://www.essen-und-trinken.de/rezepte/59961-rzpt-lachsfilet-mit-spekulatiuskruste

### ASCII-Tabelle als Hilfestellung
*(unter Linux mit `ascii -d` erzeugbar)*

```
0 NUL    16 DLE    32      48 0    64 @    80 P    96 `   112 p
1 SOH    17 DC1    33 !    49 1    65 A    81 Q    97 a   113 q
2 STX    18 DC2    34 "    50 2    66 B    82 R    98 b   114 r
3 ETX    19 DC3    35 #    51 3    67 C    83 S    99 c   115 s
4 EOT    20 DC4    36 $    52 4    68 D    84 T   100 d   116 t
5 ENQ    21 NAK    37 %    53 5    69 E    85 U   101 e   117 u
6 ACK    22 SYN    38 &    54 6    70 F    86 V   102 f   118 v
7 BEL    23 ETB    39 '    55 7    71 G    87 W   103 g   119 w
8 BS     24 CAN    40 (    56 8    72 H    88 X   104 h   120 x
9 HT     25 EM     41 )    57 9    73 I    89 Y   105 i   121 y
10 LF    26 SUB    42 *    58 :    74 J    90 Z   106 j   122 z
11 VT    27 ESC    43 +    59 ;    75 K    91 [   107 k   123 {
12 FF    28 FS     44 ,    60 <    76 L    92 \   108 l   124 |
13 CR    29 GS     45 -    61 =    77 M    93 ]   109 m   125 }
14 SO    30 RS     46 .    62 >    78 N    94 ^   110 n   126 ~
15 SI    31 US     47 /    63 ?    79 O    95 _   111 o   127 DEL
```
Zu beachten dabei: Die Zeichen mit den Zahlwerten 0 bis einschließlich 31 sind *control characters*, welche auf den meisten Konsolen eher etwas *bewirken* (z.B. ist 13 ein Zeilenumbruch), als etwas anzuzeigen.