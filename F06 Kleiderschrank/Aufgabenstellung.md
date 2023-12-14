# F06 Kleiderschrank
## Backstory 
Die Pinguine sind sehr ordentliche Tiere.
Deswegen verwalten sie auch ihre Kleiderschränke mit Struktur.
Verschiedene Pinguine bevorzugen aber verschiedene Datenstrukturen um ihren Schrank zu verwalten.
Ebenso sind die Piguine begeistert von den neusten Techniktrends und würden entsprechend ihres aktuellen Drangs zur 
Digitalisierung auch ihre Kleiderschränke digital verwalten wollen.
Kannst du den Pinguinen helfen, ihre Kleiderschränke in Java zu verwalten?

## 1: Kleiderstangen

Pinguin Rick bevorzugt es, seine Kleider an einer Kleiderstange aufzuhängen.
Diese wird in Form einer einfach verketteten Liste verwaltet:
Er auf den ersten und letzten Kleiderhaken zugreifen, für jeden Kleiderhaken wird gespeichert, welcher Haken dahinter 
auf der Kleiderstange hängt.
Ebenso sollen verschiedene Methoden implementiert werden, etwa um neue Kleidund an bestimmten Stellen an die Stange zu hängen.
Versuche diese Methoden sowohl rekursiv, als auch iterativ zu implementieren.

### 1.1 
Implementiere eine einfach verkettete Liste um die Kleiderstange zu verwalten.
Diese hat außerdem eine Methode ```add(T element)```, welche einen neuen Kleiderhaken mit ```element``` als Inhalt an den Anfang der Kleiderstange hängt.

### 1.2 Rekursive Kleiderstangen
Implementiere die folgenden Methoden rekursiv:
- ```removeNthRec(int n)``` entfernt das nte Element der Liste und gibt den an der Stelle in der Liste gespeicherten Wert zurück.
```null``` wenn nicht vorhanden.
- ```filterSocksRec()``` filtert alle Elemente,deren Wert vom Typ Socke ist. *Hinweis*: mit ```instanceof``` könnt ihr 
in Java prüfen, ob ein Objekt einer bestimmten Klasse angehört.
- Die Methode ```insertAtRec(int n, T element)``` fügt einen neuen Kleiderhaken mit Wert ```element```
an nter Stelle ein.
- ```containsRec(T element)``` überprüft, ob das übergebene Element in der Liste enthalten ist.

### 1.3 Iterative Kleiderstangen
Nein, nein, nein! Pinguin Rick ist gerade eingefallen, dass er die Methoden doch lieber iterativ möchte! Hilf ihm und 
implementiere die Methoden aus 1.2 je ohne Rekursion zu verwenden! 

## 2. Kleiderstapel

Manche Pinguine bevorzugen es, ihre Kleidung einfach in einer Ecke ihres Iglus zu stapeln.
Unglücklicherweise können sie so jedoch stets nur auf das oberste Element ihres Kleiderstapels zugreifen und entweder 
dieses vom Stapel nehmen, oder ein neues Element oben auf den Stapel legen.
Dem kann jedoch Abhilfe geschaffen werden, indem die Pinguine alle Elemente von oben nacheinander auf einen zweiten Stapel
legen. Dazu die Klasse ```Kleiderstapel```, welche zwei Stacks verwaltet, einen Stapel um Kleidung zu lagern und einen
"Zwischenspeicher" auf dem die obersten Elemente des ersten Stacks gelegt werden um auf die Mitte des Stacks zuzugreifen.
Jedoch können keine neuen Elemente für den zweiten Stapel erstellt werden.

### 2.1
Implementiere die Klasse ```Stapel```, welche ein Stack darstellt. Es soll hier nur auf das oberste Element zugegriffen 
werden können. Wie gewohnt kann man mit ```push(T element)``` ein neues Element oben auf den Stack legen. Die Methode 
```pop()``` entfernt das oberste Element des Stacks und gibt dieses zurück. ```reverse(Stapel<S> stapel)``` dreht den 
übergebenen Stapel um und gibt den neuen Stapel zurück.

### 2.2 
Die Klasse Kleiderstapel verwaltet zwei Stapel.
Es sollen die folgenden Methoden implementiert werden:
- ```push(T element)``` pusht auf den ersten Stapel
- ```pop()``` entfernt das oberste Element vom ersten Stapel und gibt dieses zurück. ```null``` für einen leeren Stapel.
- ```remove(T element)``` entfernt das erste auftreten von ```element``` aus dem Stack. Hierfür wird geprüft, ob das oberste
Element des ersten Stacks das gesuchte ist. Wenn ja, so wird dieses entfernt. Wenn nein, kommt dieses oben auf den zweiten Stack 
und der erste Stack wird weiter durchsucht.
- ```removeAll(T element)``` entfernt nach dem selben Prinip wie ```remove``` alle Auftreten von ```element```.
- ```mergeStacks()``` merged den ersten und zweiten Stack i´zusammen, sodass das oberste Element vom ersten auf das oberste
Element vom zweiten usw. folgt. Ist ein Stack leer, so folgen alle Elemente des anderen nacheinander.



## 3.Wäscheleinen Graph

Der Pinguin Rollo bevorzugt es, seine Kleidung durch ein elaboriertes System von Wäscheleinen zu verwalten.
Da man im Wäscheleinengewirr jedoch schnell den Überblick verliert, bittet er dich darum diese mittels eines Graphen 
darzustellen. Die einzelenen Knoten stehen dabei für einzelne Kleidungsstücke, während die Kanten des Graphen die Wäscheleinen 
darstellen sollen. Ebenso sollen die Kanten gerichtet sein, was beim Aufstellen der Wäscheleinen helfen soll.

Hierfür wird die generische Klasse ```Waescheleinengraph<T>``` verwendet. ```T``` soll hierbei der Typ der Knoten sein.
Der Graph wird dargestellt durch eine Map, welche die Knoten als Keys und als Values eine Liste von Knoten enthält, zu
denen vom Key eine Kante führt.

### 3.1 Erste Methoden
- ```addNode(T element)``` fügt einen Knoten zur Map mit einer leeren Liste als Value hinzu. Ist ```element``` bereits als 
Knoten vorhanden, so ändert sich nichts.
- ```addEdge(T from , T to)``` fügt eine neue Kante von ```from``` nach ```to``` hinzu.
- 
