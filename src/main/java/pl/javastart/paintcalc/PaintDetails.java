package pl.javastart.paintcalc;

class PaintDetails {
    private int coverage;
    private int coats;

    public PaintDetails(int coverage, int coats) {
        this.coverage = coverage;
        this.coats = coats;
    }

    public int getCoverage() {
        return coverage;
    }

    public int getCoats() {
        return coats;
    }
}
