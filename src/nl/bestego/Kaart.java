package nl.bestego;

public class Kaart {
    String kleur;
    String soort;
    int waarde;

    public Kaart(String kleur, String soort, int waarde) {
        this.kleur = kleur;
        this.soort = soort;
        this.waarde = waarde;
    }

    public String toString() {
        return kleur + "-" + soort;
    }
}
