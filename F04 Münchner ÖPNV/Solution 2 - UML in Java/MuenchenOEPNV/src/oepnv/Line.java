package oepnv;

public abstract class Line {
    protected LineNumber lineNumber;

    public Line(LineNumber lineNumber) {
        this.lineNumber = lineNumber;
    }
}
