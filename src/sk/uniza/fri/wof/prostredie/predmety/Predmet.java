package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.hra.Hrac;
public class Predmet implements IPredmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa(Hrac hrac) {
        System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
    }
}
